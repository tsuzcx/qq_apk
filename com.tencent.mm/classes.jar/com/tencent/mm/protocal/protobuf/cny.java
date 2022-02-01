package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cny
  extends com.tencent.mm.bx.a
{
  public String CVv;
  public String CVw;
  public String Dal;
  public String Dam;
  public String Dqd;
  public int EhQ;
  public bvn Eif;
  public String hnC;
  public int ijM;
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152685);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      if (this.Dal != null) {
        paramVarArgs.d(3, this.Dal);
      }
      if (this.Dam != null) {
        paramVarArgs.d(4, this.Dam);
      }
      paramVarArgs.aR(5, this.ijM);
      if (this.CVv != null) {
        paramVarArgs.d(6, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(7, this.CVw);
      }
      if (this.hnC != null) {
        paramVarArgs.d(8, this.hnC);
      }
      paramVarArgs.aR(9, this.EhQ);
      if (this.Eif != null)
      {
        paramVarArgs.kX(10, this.Eif.computeSize());
        this.Eif.writeFields(paramVarArgs);
      }
      if (this.Dqd != null) {
        paramVarArgs.d(11, this.Dqd);
      }
      AppMethodBeat.o(152685);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label890;
      }
    }
    label890:
    for (int i = f.a.a.b.b.a.e(1, this.mAQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mBV);
      }
      i = paramInt;
      if (this.Dal != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Dal);
      }
      paramInt = i;
      if (this.Dam != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dam);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.ijM);
      paramInt = i;
      if (this.CVv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CVv);
      }
      i = paramInt;
      if (this.CVw != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CVw);
      }
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hnC);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.EhQ);
      paramInt = i;
      if (this.Eif != null) {
        paramInt = i + f.a.a.a.kW(10, this.Eif.computeSize());
      }
      i = paramInt;
      if (this.Dqd != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Dqd);
      }
      AppMethodBeat.o(152685);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152685);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cny localcny = (cny)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152685);
          return -1;
        case 1: 
          localcny.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 2: 
          localcny.mBV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 3: 
          localcny.Dal = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 4: 
          localcny.Dam = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 5: 
          localcny.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152685);
          return 0;
        case 6: 
          localcny.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 7: 
          localcny.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 8: 
          localcny.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 9: 
          localcny.EhQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152685);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bvn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcny.Eif = ((bvn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152685);
          return 0;
        }
        localcny.Dqd = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152685);
        return 0;
      }
      AppMethodBeat.o(152685);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cny
 * JD-Core Version:    0.7.0.1
 */