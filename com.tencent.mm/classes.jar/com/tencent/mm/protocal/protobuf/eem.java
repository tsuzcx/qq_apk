package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eem
  extends dyl
{
  public long KlG;
  public String SCm;
  public String Uin;
  public String jDL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260798);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Uin != null) {
        paramVarArgs.f(2, this.Uin);
      }
      if (this.jDL != null) {
        paramVarArgs.f(3, this.jDL);
      }
      paramVarArgs.bm(4, this.KlG);
      if (this.SCm != null) {
        paramVarArgs.f(5, this.SCm);
      }
      AppMethodBeat.o(260798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label512;
      }
    }
    label512:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Uin != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Uin);
      }
      i = paramInt;
      if (this.jDL != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jDL);
      }
      i += g.a.a.b.b.a.p(4, this.KlG);
      paramInt = i;
      if (this.SCm != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SCm);
      }
      AppMethodBeat.o(260798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(260798);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eem localeem = (eem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260798);
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
            localeem.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(260798);
          return 0;
        case 2: 
          localeem.Uin = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(260798);
          return 0;
        case 3: 
          localeem.jDL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(260798);
          return 0;
        case 4: 
          localeem.KlG = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(260798);
          return 0;
        }
        localeem.SCm = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(260798);
        return 0;
      }
      AppMethodBeat.o(260798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eem
 * JD-Core Version:    0.7.0.1
 */