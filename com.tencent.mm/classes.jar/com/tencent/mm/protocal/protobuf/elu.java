package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elu
  extends dyl
{
  public int SZz;
  public int UnL;
  public String UnN;
  public String UnO;
  public String UnP;
  public String fIF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(130919);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UnO != null) {
        paramVarArgs.f(2, this.UnO);
      }
      if (this.UnN != null) {
        paramVarArgs.f(3, this.UnN);
      }
      if (this.UnP != null) {
        paramVarArgs.f(4, this.UnP);
      }
      if (this.fIF != null) {
        paramVarArgs.f(5, this.fIF);
      }
      paramVarArgs.aY(6, this.UnL);
      paramVarArgs.aY(7, this.SZz);
      AppMethodBeat.o(130919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label624;
      }
    }
    label624:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UnO != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UnO);
      }
      i = paramInt;
      if (this.UnN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UnN);
      }
      paramInt = i;
      if (this.UnP != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UnP);
      }
      i = paramInt;
      if (this.fIF != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fIF);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.UnL);
      int j = g.a.a.b.b.a.bM(7, this.SZz);
      AppMethodBeat.o(130919);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(130919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        elu localelu = (elu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(130919);
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
            localelu.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(130919);
          return 0;
        case 2: 
          localelu.UnO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 3: 
          localelu.UnN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 4: 
          localelu.UnP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 5: 
          localelu.fIF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(130919);
          return 0;
        case 6: 
          localelu.UnL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(130919);
          return 0;
        }
        localelu.SZz = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(130919);
        return 0;
      }
      AppMethodBeat.o(130919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elu
 * JD-Core Version:    0.7.0.1
 */