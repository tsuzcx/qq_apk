package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czd
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public chx EqZ;
  public cyd Era;
  public String Erb;
  public int Erc;
  public int Erd;
  public String Id;
  public String mAQ;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      paramVarArgs.aR(3, this.CreateTime);
      if (this.EqZ != null)
      {
        paramVarArgs.kX(4, this.EqZ.computeSize());
        this.EqZ.writeFields(paramVarArgs);
      }
      if (this.Era != null)
      {
        paramVarArgs.kX(5, this.Era.computeSize());
        this.Era.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(6, this.timeStamp);
      if (this.Erb != null) {
        paramVarArgs.d(7, this.Erb);
      }
      paramVarArgs.aR(8, this.Erc);
      paramVarArgs.aR(9, this.Erd);
      AppMethodBeat.o(118475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.b.b.a.e(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i += f.a.a.b.b.a.bA(3, this.CreateTime);
      paramInt = i;
      if (this.EqZ != null) {
        paramInt = i + f.a.a.a.kW(4, this.EqZ.computeSize());
      }
      i = paramInt;
      if (this.Era != null) {
        i = paramInt + f.a.a.a.kW(5, this.Era.computeSize());
      }
      i += f.a.a.b.b.a.q(6, this.timeStamp);
      paramInt = i;
      if (this.Erb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Erb);
      }
      i = f.a.a.b.b.a.bA(8, this.Erc);
      int j = f.a.a.b.b.a.bA(9, this.Erd);
      AppMethodBeat.o(118475);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(118475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czd localczd = (czd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118475);
          return -1;
        case 1: 
          localczd.Id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 2: 
          localczd.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 3: 
          localczd.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118475);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczd.EqZ = ((chx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczd.Era = ((cyd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 6: 
          localczd.timeStamp = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(118475);
          return 0;
        case 7: 
          localczd.Erb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 8: 
          localczd.Erc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118475);
          return 0;
        }
        localczd.Erd = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118475);
        return 0;
      }
      AppMethodBeat.o(118475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czd
 * JD-Core Version:    0.7.0.1
 */