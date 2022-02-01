package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpz
  extends dyy
{
  public int Tbr;
  public String Tbs;
  public String Tbt;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91476);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.aY(4, this.Tbr);
      if (this.Tbs != null) {
        paramVarArgs.f(5, this.Tbs);
      }
      if (this.Tbt != null) {
        paramVarArgs.f(6, this.Tbt);
      }
      AppMethodBeat.o(91476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label560;
      }
    }
    label560:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.Tbr);
      paramInt = i;
      if (this.Tbs != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Tbs);
      }
      i = paramInt;
      if (this.Tbt != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Tbt);
      }
      AppMethodBeat.o(91476);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bpz localbpz = (bpz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91476);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localbpz.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(91476);
          return 0;
        case 2: 
          localbpz.tqa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91476);
          return 0;
        case 3: 
          localbpz.tqb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91476);
          return 0;
        case 4: 
          localbpz.Tbr = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91476);
          return 0;
        case 5: 
          localbpz.Tbs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91476);
          return 0;
        }
        localbpz.Tbt = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91476);
        return 0;
      }
      AppMethodBeat.o(91476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpz
 * JD-Core Version:    0.7.0.1
 */