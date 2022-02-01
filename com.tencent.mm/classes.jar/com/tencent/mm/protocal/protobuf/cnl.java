package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class cnl
  extends dyy
{
  public String RLJ;
  public cmt TuR;
  public String Tvb;
  public String Tvc;
  public String Tvd;
  public String Tve;
  public int Tvf;
  public String mVB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123613);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123613);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TuR != null)
      {
        paramVarArgs.oE(2, this.TuR.computeSize());
        this.TuR.writeFields(paramVarArgs);
      }
      if (this.Tvc != null) {
        paramVarArgs.f(3, this.Tvc);
      }
      if (this.RLJ != null) {
        paramVarArgs.f(4, this.RLJ);
      }
      if (this.Tvd != null) {
        paramVarArgs.f(5, this.Tvd);
      }
      if (this.Tve != null) {
        paramVarArgs.f(6, this.Tve);
      }
      paramVarArgs.aY(7, this.Tvf);
      if (this.Tvb != null) {
        paramVarArgs.f(8, this.Tvb);
      }
      if (this.mVB != null) {
        paramVarArgs.f(9, this.mVB);
      }
      AppMethodBeat.o(123613);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label882;
      }
    }
    label882:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TuR != null) {
        paramInt = i + g.a.a.a.oD(2, this.TuR.computeSize());
      }
      i = paramInt;
      if (this.Tvc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tvc);
      }
      paramInt = i;
      if (this.RLJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RLJ);
      }
      i = paramInt;
      if (this.Tvd != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Tvd);
      }
      paramInt = i;
      if (this.Tve != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tve);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Tvf);
      paramInt = i;
      if (this.Tvb != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Tvb);
      }
      i = paramInt;
      if (this.mVB != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.mVB);
      }
      AppMethodBeat.o(123613);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123613);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123613);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnl localcnl = (cnl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123613);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcnl.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cmt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cmt)localObject2).parseFrom((byte[])localObject1);
            }
            localcnl.TuR = ((cmt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 3: 
          localcnl.Tvc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 4: 
          localcnl.RLJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 5: 
          localcnl.Tvd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 6: 
          localcnl.Tve = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 7: 
          localcnl.Tvf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123613);
          return 0;
        case 8: 
          localcnl.Tvb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123613);
          return 0;
        }
        localcnl.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(123613);
        return 0;
      }
      AppMethodBeat.o(123613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnl
 * JD-Core Version:    0.7.0.1
 */