package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aow
  extends cvw
{
  public alz GDS;
  public alw GEg;
  public String GGf;
  public String GGg;
  public alx GGh;
  public aov GGi;
  public String GGj;
  public String cUA;
  public String cUB;
  public float dBu;
  public int dvm;
  public float dzE;
  public b lastBuffer;
  public String objectNonceId;
  public arv rRJ;
  public long rRn;
  public b rSO;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189360);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GEg != null)
      {
        paramVarArgs.lJ(2, this.GEg.computeSize());
        this.GEg.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aZ(4, this.rRn);
      paramVarArgs.aS(5, this.dvm);
      paramVarArgs.y(6, this.dBu);
      paramVarArgs.y(7, this.dzE);
      if (this.objectNonceId != null) {
        paramVarArgs.d(8, this.objectNonceId);
      }
      if (this.GGf != null) {
        paramVarArgs.d(9, this.GGf);
      }
      paramVarArgs.aS(10, this.scene);
      if (this.GGg != null) {
        paramVarArgs.d(11, this.GGg);
      }
      if (this.rRJ != null)
      {
        paramVarArgs.lJ(12, this.rRJ.computeSize());
        this.rRJ.writeFields(paramVarArgs);
      }
      if (this.GGh != null)
      {
        paramVarArgs.lJ(13, this.GGh.computeSize());
        this.GGh.writeFields(paramVarArgs);
      }
      if (this.rSO != null) {
        paramVarArgs.c(14, this.rSO);
      }
      if (this.GDS != null)
      {
        paramVarArgs.lJ(15, this.GDS.computeSize());
        this.GDS.writeFields(paramVarArgs);
      }
      if (this.cUA != null) {
        paramVarArgs.d(16, this.cUA);
      }
      if (this.cUB != null) {
        paramVarArgs.d(17, this.cUB);
      }
      if (this.GGi != null)
      {
        paramVarArgs.lJ(18, this.GGi.computeSize());
        this.GGi.writeFields(paramVarArgs);
      }
      if (this.GGj != null) {
        paramVarArgs.d(19, this.GGj);
      }
      AppMethodBeat.o(189360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1800;
      }
    }
    label1800:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GEg != null) {
        paramInt = i + f.a.a.a.lI(2, this.GEg.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = i + f.a.a.b.b.a.p(4, this.rRn) + f.a.a.b.b.a.bz(5, this.dvm) + f.a.a.b.b.a.amE(6) + f.a.a.b.b.a.amE(7);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.objectNonceId);
      }
      i = paramInt;
      if (this.GGf != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GGf);
      }
      i += f.a.a.b.b.a.bz(10, this.scene);
      paramInt = i;
      if (this.GGg != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GGg);
      }
      i = paramInt;
      if (this.rRJ != null) {
        i = paramInt + f.a.a.a.lI(12, this.rRJ.computeSize());
      }
      paramInt = i;
      if (this.GGh != null) {
        paramInt = i + f.a.a.a.lI(13, this.GGh.computeSize());
      }
      i = paramInt;
      if (this.rSO != null) {
        i = paramInt + f.a.a.b.b.a.b(14, this.rSO);
      }
      paramInt = i;
      if (this.GDS != null) {
        paramInt = i + f.a.a.a.lI(15, this.GDS.computeSize());
      }
      i = paramInt;
      if (this.cUA != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.cUA);
      }
      paramInt = i;
      if (this.cUB != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.cUB);
      }
      i = paramInt;
      if (this.GGi != null) {
        i = paramInt + f.a.a.a.lI(18, this.GGi.computeSize());
      }
      paramInt = i;
      if (this.GGj != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.GGj);
      }
      AppMethodBeat.o(189360);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189360);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aow localaow = (aow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189360);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaow.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189360);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaow.GEg = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189360);
          return 0;
        case 3: 
          localaow.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(189360);
          return 0;
        case 4: 
          localaow.rRn = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(189360);
          return 0;
        case 5: 
          localaow.dvm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189360);
          return 0;
        case 6: 
          localaow.dBu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(189360);
          return 0;
        case 7: 
          localaow.dzE = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(189360);
          return 0;
        case 8: 
          localaow.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189360);
          return 0;
        case 9: 
          localaow.GGf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189360);
          return 0;
        case 10: 
          localaow.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189360);
          return 0;
        case 11: 
          localaow.GGg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189360);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaow.rRJ = ((arv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189360);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaow.GGh = ((alx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189360);
          return 0;
        case 14: 
          localaow.rSO = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(189360);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaow.GDS = ((alz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189360);
          return 0;
        case 16: 
          localaow.cUA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189360);
          return 0;
        case 17: 
          localaow.cUB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189360);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaow.GGi = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189360);
          return 0;
        }
        localaow.GGj = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(189360);
        return 0;
      }
      AppMethodBeat.o(189360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aow
 * JD-Core Version:    0.7.0.1
 */