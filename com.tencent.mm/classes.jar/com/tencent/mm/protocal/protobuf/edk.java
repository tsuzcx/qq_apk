package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edk
  extends dyl
{
  public int RVf;
  public int TKm;
  public String UhP;
  public String UserName;
  public String lpy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152688);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.lpy != null) {
        paramVarArgs.f(3, this.lpy);
      }
      paramVarArgs.aY(4, this.TKm);
      paramVarArgs.aY(5, this.RVf);
      if (this.UhP != null) {
        paramVarArgs.f(6, this.UhP);
      }
      AppMethodBeat.o(152688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label556;
      }
    }
    label556:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.lpy != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lpy);
      }
      i = i + g.a.a.b.b.a.bM(4, this.TKm) + g.a.a.b.b.a.bM(5, this.RVf);
      paramInt = i;
      if (this.UhP != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UhP);
      }
      AppMethodBeat.o(152688);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152688);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        edk localedk = (edk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152688);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localedk.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(152688);
          return 0;
        case 2: 
          localedk.UserName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152688);
          return 0;
        case 3: 
          localedk.lpy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152688);
          return 0;
        case 4: 
          localedk.TKm = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152688);
          return 0;
        case 5: 
          localedk.RVf = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152688);
          return 0;
        }
        localedk.UhP = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152688);
        return 0;
      }
      AppMethodBeat.o(152688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edk
 * JD-Core Version:    0.7.0.1
 */