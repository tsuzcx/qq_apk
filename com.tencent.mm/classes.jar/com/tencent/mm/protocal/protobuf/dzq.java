package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzq
  extends com.tencent.mm.bx.a
{
  public String Cbs;
  public String Lyd;
  public String Lye;
  public int Lyf;
  public int Lyg;
  public String Lyh;
  public String Lyi;
  public aji Lyj;
  public alj Lyk;
  public dza Lyl;
  public int hrU;
  public String nEF;
  public int recommendType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203877);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nEF != null) {
        paramVarArgs.d(1, this.nEF);
      }
      if (this.Lyd != null) {
        paramVarArgs.d(2, this.Lyd);
      }
      if (this.Lye != null) {
        paramVarArgs.d(3, this.Lye);
      }
      paramVarArgs.aR(4, this.Lyf);
      paramVarArgs.aR(5, this.Lyg);
      if (this.Lyh != null) {
        paramVarArgs.d(6, this.Lyh);
      }
      if (this.Lyi != null) {
        paramVarArgs.d(7, this.Lyi);
      }
      if (this.Cbs != null) {
        paramVarArgs.d(8, this.Cbs);
      }
      paramVarArgs.aR(9, this.hrU);
      if (this.Lyj != null)
      {
        paramVarArgs.kX(10, this.Lyj.computeSize());
        this.Lyj.writeFields(paramVarArgs);
      }
      if (this.Lyk != null)
      {
        paramVarArgs.kX(11, this.Lyk.computeSize());
        this.Lyk.writeFields(paramVarArgs);
      }
      if (this.Lyl != null)
      {
        paramVarArgs.kX(12, this.Lyl.computeSize());
        this.Lyl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.recommendType);
      AppMethodBeat.o(203877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nEF == null) {
        break label1170;
      }
    }
    label1170:
    for (int i = f.a.a.b.b.a.e(1, this.nEF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lyd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Lyd);
      }
      i = paramInt;
      if (this.Lye != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Lye);
      }
      i = i + f.a.a.b.b.a.bA(4, this.Lyf) + f.a.a.b.b.a.bA(5, this.Lyg);
      paramInt = i;
      if (this.Lyh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Lyh);
      }
      i = paramInt;
      if (this.Lyi != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Lyi);
      }
      paramInt = i;
      if (this.Cbs != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Cbs);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.hrU);
      paramInt = i;
      if (this.Lyj != null) {
        paramInt = i + f.a.a.a.kW(10, this.Lyj.computeSize());
      }
      i = paramInt;
      if (this.Lyk != null) {
        i = paramInt + f.a.a.a.kW(11, this.Lyk.computeSize());
      }
      paramInt = i;
      if (this.Lyl != null) {
        paramInt = i + f.a.a.a.kW(12, this.Lyl.computeSize());
      }
      i = f.a.a.b.b.a.bA(13, this.recommendType);
      AppMethodBeat.o(203877);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203877);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzq localdzq = (dzq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203877);
          return -1;
        case 1: 
          localdzq.nEF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203877);
          return 0;
        case 2: 
          localdzq.Lyd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203877);
          return 0;
        case 3: 
          localdzq.Lye = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203877);
          return 0;
        case 4: 
          localdzq.Lyf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203877);
          return 0;
        case 5: 
          localdzq.Lyg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203877);
          return 0;
        case 6: 
          localdzq.Lyh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203877);
          return 0;
        case 7: 
          localdzq.Lyi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203877);
          return 0;
        case 8: 
          localdzq.Cbs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203877);
          return 0;
        case 9: 
          localdzq.hrU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203877);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aji();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aji)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzq.Lyj = ((aji)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203877);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzq.Lyk = ((alj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203877);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dza();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dza)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzq.Lyl = ((dza)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203877);
          return 0;
        }
        localdzq.recommendType = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(203877);
        return 0;
      }
      AppMethodBeat.o(203877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzq
 * JD-Core Version:    0.7.0.1
 */