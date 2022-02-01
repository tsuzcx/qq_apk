package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eot
  extends dyl
{
  public LinkedList<Integer> TZD;
  public String Uij;
  public String Uik;
  public String appid;
  public String fAo;
  
  public eot()
  {
    AppMethodBeat.i(123656);
    this.TZD = new LinkedList();
    AppMethodBeat.o(123656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123657);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      paramVarArgs.e(3, 2, this.TZD);
      if (this.Uij != null) {
        paramVarArgs.f(4, this.Uij);
      }
      if (this.fAo != null) {
        paramVarArgs.f(5, this.fAo);
      }
      if (this.Uik != null) {
        paramVarArgs.f(6, this.Uik);
      }
      AppMethodBeat.o(123657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label591;
      }
    }
    label591:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.appid);
      }
      i += g.a.a.a.c(3, 2, this.TZD);
      paramInt = i;
      if (this.Uij != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Uij);
      }
      i = paramInt;
      if (this.fAo != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fAo);
      }
      paramInt = i;
      if (this.Uik != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Uik);
      }
      AppMethodBeat.o(123657);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TZD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eot localeot = (eot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123657);
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
            localeot.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(123657);
          return 0;
        case 2: 
          localeot.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123657);
          return 0;
        case 3: 
          localeot.TZD.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
          AppMethodBeat.o(123657);
          return 0;
        case 4: 
          localeot.Uij = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123657);
          return 0;
        case 5: 
          localeot.fAo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123657);
          return 0;
        }
        localeot.Uik = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(123657);
        return 0;
      }
      AppMethodBeat.o(123657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eot
 * JD-Core Version:    0.7.0.1
 */