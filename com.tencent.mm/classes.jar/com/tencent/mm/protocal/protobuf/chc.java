package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chc
  extends ckq
{
  public int DIc;
  public String fVv;
  public String fVw;
  public String fVx;
  public String fVy;
  public String fVz;
  public String vJI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fVv != null) {
        paramVarArgs.d(2, this.fVv);
      }
      if (this.fVw != null) {
        paramVarArgs.d(3, this.fVw);
      }
      if (this.fVx != null) {
        paramVarArgs.d(4, this.fVx);
      }
      if (this.fVy != null) {
        paramVarArgs.d(5, this.fVy);
      }
      if (this.fVz != null) {
        paramVarArgs.d(6, this.fVz);
      }
      paramVarArgs.aR(7, this.DIc);
      if (this.vJI != null) {
        paramVarArgs.d(8, this.vJI);
      }
      AppMethodBeat.o(152666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fVv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fVv);
      }
      i = paramInt;
      if (this.fVw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fVw);
      }
      paramInt = i;
      if (this.fVx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fVx);
      }
      i = paramInt;
      if (this.fVy != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.fVy);
      }
      paramInt = i;
      if (this.fVz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.fVz);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.DIc);
      paramInt = i;
      if (this.vJI != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.vJI);
      }
      AppMethodBeat.o(152666);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chc localchc = (chc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152666);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152666);
          return 0;
        case 2: 
          localchc.fVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 3: 
          localchc.fVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 4: 
          localchc.fVx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 5: 
          localchc.fVy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 6: 
          localchc.fVz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 7: 
          localchc.DIc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152666);
          return 0;
        }
        localchc.vJI = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152666);
        return 0;
      }
      AppMethodBeat.o(152666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chc
 * JD-Core Version:    0.7.0.1
 */