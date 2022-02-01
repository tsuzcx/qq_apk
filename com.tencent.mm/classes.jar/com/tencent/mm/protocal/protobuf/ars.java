package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class ars
  extends cvc
{
  public alk Glv;
  public aln Gnb;
  public LinkedList<bya> Gnv;
  public long GpM;
  public String GpN;
  public long GpO;
  public LinkedList<ask> GpP;
  public int GpQ;
  public LinkedList<dij> Gpk;
  public b Gpp;
  public int OeB;
  public String OeC;
  public float dAp;
  public int duh;
  public float dyz;
  public b lastBuffer;
  public int pullType;
  public String rTn;
  public String sessionId;
  
  public ars()
  {
    AppMethodBeat.i(184211);
    this.Gnv = new LinkedList();
    this.Gpk = new LinkedList();
    this.GpP = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.rTn != null) {
        paramVarArgs.d(4, this.rTn);
      }
      paramVarArgs.aS(5, this.pullType);
      if (this.Glv != null)
      {
        paramVarArgs.lC(6, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      paramVarArgs.z(7, this.dAp);
      paramVarArgs.z(8, this.dyz);
      if (this.sessionId != null) {
        paramVarArgs.d(9, this.sessionId);
      }
      if (this.Gnb != null)
      {
        paramVarArgs.lC(10, this.Gnb.computeSize());
        this.Gnb.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.Gnv);
      paramVarArgs.aS(12, this.OeB);
      paramVarArgs.aS(13, this.duh);
      paramVarArgs.aY(14, this.GpM);
      if (this.GpN != null) {
        paramVarArgs.d(15, this.GpN);
      }
      paramVarArgs.e(16, 8, this.Gpk);
      paramVarArgs.aY(17, this.GpO);
      paramVarArgs.e(18, 8, this.GpP);
      if (this.Gpp != null) {
        paramVarArgs.c(19, this.Gpp);
      }
      paramVarArgs.aS(20, this.GpQ);
      if (this.OeC != null) {
        paramVarArgs.d(21, this.OeC);
      }
      AppMethodBeat.o(169056);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1772;
      }
    }
    label1772:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.rTn != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.rTn);
      }
      i += f.a.a.b.b.a.bz(5, this.pullType);
      paramInt = i;
      if (this.Glv != null) {
        paramInt = i + f.a.a.a.lB(6, this.Glv.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.alU(7) + f.a.a.b.b.a.alU(8);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.sessionId);
      }
      i = paramInt;
      if (this.Gnb != null) {
        i = paramInt + f.a.a.a.lB(10, this.Gnb.computeSize());
      }
      i = i + f.a.a.a.c(11, 8, this.Gnv) + f.a.a.b.b.a.bz(12, this.OeB) + f.a.a.b.b.a.bz(13, this.duh) + f.a.a.b.b.a.p(14, this.GpM);
      paramInt = i;
      if (this.GpN != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.GpN);
      }
      i = paramInt + f.a.a.a.c(16, 8, this.Gpk) + f.a.a.b.b.a.p(17, this.GpO) + f.a.a.a.c(18, 8, this.GpP);
      paramInt = i;
      if (this.Gpp != null) {
        paramInt = i + f.a.a.b.b.a.b(19, this.Gpp);
      }
      i = paramInt + f.a.a.b.b.a.bz(20, this.GpQ);
      paramInt = i;
      if (this.OeC != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.OeC);
      }
      AppMethodBeat.o(169056);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gnv.clear();
        this.Gpk.clear();
        this.GpP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169056);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ars localars = (ars)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localars.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 3: 
          localars.lastBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(169056);
          return 0;
        case 4: 
          localars.rTn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 5: 
          localars.pullType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169056);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localars.Glv = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 7: 
          localars.dAp = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169056);
          return 0;
        case 8: 
          localars.dyz = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169056);
          return 0;
        case 9: 
          localars.sessionId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aln();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aln)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localars.Gnb = ((aln)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bya();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bya)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localars.Gnv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 12: 
          localars.OeB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169056);
          return 0;
        case 13: 
          localars.duh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169056);
          return 0;
        case 14: 
          localars.GpM = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169056);
          return 0;
        case 15: 
          localars.GpN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dij();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localars.Gpk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 17: 
          localars.GpO = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169056);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ask();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ask)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localars.GpP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 19: 
          localars.Gpp = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(169056);
          return 0;
        case 20: 
          localars.GpQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169056);
          return 0;
        }
        localars.OeC = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169056);
        return 0;
      }
      AppMethodBeat.o(169056);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ars
 * JD-Core Version:    0.7.0.1
 */