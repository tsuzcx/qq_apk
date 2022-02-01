package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lt
  extends dyl
{
  public int RNt;
  public int RQD;
  public String RQE;
  public String RQF;
  public String RQG;
  public String RQH;
  public String RQI;
  public String RQJ;
  public String RQK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155394);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RNt);
      paramVarArgs.aY(3, this.RQD);
      if (this.RQE != null) {
        paramVarArgs.f(4, this.RQE);
      }
      if (this.RQF != null) {
        paramVarArgs.f(5, this.RQF);
      }
      if (this.RQG != null) {
        paramVarArgs.f(6, this.RQG);
      }
      if (this.RQH != null) {
        paramVarArgs.f(7, this.RQH);
      }
      if (this.RQI != null) {
        paramVarArgs.f(8, this.RQI);
      }
      if (this.RQJ != null) {
        paramVarArgs.f(9, this.RQJ);
      }
      if (this.RQK != null) {
        paramVarArgs.f(10, this.RQK);
      }
      AppMethodBeat.o(155394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label804;
      }
    }
    label804:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RNt) + g.a.a.b.b.a.bM(3, this.RQD);
      paramInt = i;
      if (this.RQE != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RQE);
      }
      i = paramInt;
      if (this.RQF != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RQF);
      }
      paramInt = i;
      if (this.RQG != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RQG);
      }
      i = paramInt;
      if (this.RQH != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RQH);
      }
      paramInt = i;
      if (this.RQI != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RQI);
      }
      i = paramInt;
      if (this.RQJ != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.RQJ);
      }
      paramInt = i;
      if (this.RQK != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RQK);
      }
      AppMethodBeat.o(155394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        lt locallt = (lt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155394);
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
            locallt.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(155394);
          return 0;
        case 2: 
          locallt.RNt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(155394);
          return 0;
        case 3: 
          locallt.RQD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(155394);
          return 0;
        case 4: 
          locallt.RQE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 5: 
          locallt.RQF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 6: 
          locallt.RQG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 7: 
          locallt.RQH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 8: 
          locallt.RQI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 9: 
          locallt.RQJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155394);
          return 0;
        }
        locallt.RQK = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(155394);
        return 0;
      }
      AppMethodBeat.o(155394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lt
 * JD-Core Version:    0.7.0.1
 */