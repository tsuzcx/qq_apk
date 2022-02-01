package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ali
  extends ckq
{
  public aht Dkw;
  public LinkedList<bow> DlG;
  public ahu DmA;
  public LinkedList<cxk> Dmz;
  public int IoU;
  public int Lym;
  public long Lyn;
  public String Lyo;
  public long Lyp;
  public float dpb;
  public float dqQ;
  public String finderUsername;
  public b lastBuffer;
  public int pullType;
  public String sessionId;
  
  public ali()
  {
    AppMethodBeat.i(184211);
    this.DlG = new LinkedList();
    this.Dmz = new LinkedList();
    AppMethodBeat.o(184211);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169056);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.finderUsername != null) {
        paramVarArgs.d(4, this.finderUsername);
      }
      paramVarArgs.aR(5, this.pullType);
      if (this.Dkw != null)
      {
        paramVarArgs.kX(6, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      paramVarArgs.x(7, this.dqQ);
      paramVarArgs.x(8, this.dpb);
      if (this.sessionId != null) {
        paramVarArgs.d(9, this.sessionId);
      }
      if (this.DmA != null)
      {
        paramVarArgs.kX(10, this.DmA.computeSize());
        this.DmA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.DlG);
      paramVarArgs.aR(12, this.Lym);
      paramVarArgs.aR(13, this.IoU);
      paramVarArgs.aG(14, this.Lyn);
      if (this.Lyo != null) {
        paramVarArgs.d(15, this.Lyo);
      }
      paramVarArgs.e(16, 8, this.Dmz);
      paramVarArgs.aG(17, this.Lyp);
      AppMethodBeat.o(169056);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1472;
      }
    }
    label1472:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.finderUsername);
      }
      i += f.a.a.b.b.a.bA(5, this.pullType);
      paramInt = i;
      if (this.Dkw != null) {
        paramInt = i + f.a.a.a.kW(6, this.Dkw.computeSize());
      }
      i = paramInt + (f.a.a.b.b.a.fY(7) + 4) + (f.a.a.b.b.a.fY(8) + 4);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.sessionId);
      }
      i = paramInt;
      if (this.DmA != null) {
        i = paramInt + f.a.a.a.kW(10, this.DmA.computeSize());
      }
      i = i + f.a.a.a.c(11, 8, this.DlG) + f.a.a.b.b.a.bA(12, this.Lym) + f.a.a.b.b.a.bA(13, this.IoU) + f.a.a.b.b.a.q(14, this.Lyn);
      paramInt = i;
      if (this.Lyo != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Lyo);
      }
      i = f.a.a.a.c(16, 8, this.Dmz);
      int j = f.a.a.b.b.a.q(17, this.Lyp);
      AppMethodBeat.o(169056);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DlG.clear();
        this.Dmz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169056);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ali localali = (ali)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(169056);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localali.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 3: 
          localali.lastBuffer = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(169056);
          return 0;
        case 4: 
          localali.finderUsername = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 5: 
          localali.pullType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169056);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localali.Dkw = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 7: 
          localali.dqQ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169056);
          return 0;
        case 8: 
          localali.dpb = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169056);
          return 0;
        case 9: 
          localali.sessionId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localali.DmA = ((ahu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bow();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bow)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localali.DlG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 12: 
          localali.Lym = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169056);
          return 0;
        case 13: 
          localali.IoU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169056);
          return 0;
        case 14: 
          localali.Lyn = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169056);
          return 0;
        case 15: 
          localali.Lyo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localali.Dmz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        }
        localali.Lyp = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(169056);
        return 0;
      }
      AppMethodBeat.o(169056);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ali
 * JD-Core Version:    0.7.0.1
 */