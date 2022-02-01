package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cw
  extends dyl
{
  public int RIv;
  public String RIw;
  public String RIx;
  public String lps;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127430);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lps != null) {
        paramVarArgs.f(2, this.lps);
      }
      paramVarArgs.aY(3, this.rWu);
      paramVarArgs.aY(4, this.RIv);
      if (this.RIw != null) {
        paramVarArgs.f(5, this.RIw);
      }
      if (this.RIx != null) {
        paramVarArgs.f(6, this.RIx);
      }
      AppMethodBeat.o(127430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lps != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lps);
      }
      i = i + g.a.a.b.b.a.bM(3, this.rWu) + g.a.a.b.b.a.bM(4, this.RIv);
      paramInt = i;
      if (this.RIw != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RIw);
      }
      i = paramInt;
      if (this.RIx != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RIx);
      }
      AppMethodBeat.o(127430);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cw localcw = (cw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127430);
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
            localcw.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(127430);
          return 0;
        case 2: 
          localcw.lps = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127430);
          return 0;
        case 3: 
          localcw.rWu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127430);
          return 0;
        case 4: 
          localcw.RIv = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127430);
          return 0;
        case 5: 
          localcw.RIw = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127430);
          return 0;
        }
        localcw.RIx = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127430);
        return 0;
      }
      AppMethodBeat.o(127430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cw
 * JD-Core Version:    0.7.0.1
 */