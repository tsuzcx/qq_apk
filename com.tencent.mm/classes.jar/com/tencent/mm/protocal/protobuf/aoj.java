package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aoj
  extends cvc
{
  public alk Gle;
  public String GmY;
  public String GmZ;
  public all Gna;
  public aln Gnb;
  public aoi Gnc;
  public String Oez;
  public float dAp;
  public String dHm;
  public String dHz;
  public int duh;
  public float dyz;
  public b lastBuffer;
  public String objectNonceId;
  public long rIZ;
  public arg rJv;
  public b rKC;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209319);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gle != null)
      {
        paramVarArgs.lC(2, this.Gle.computeSize());
        this.Gle.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aY(4, this.rIZ);
      paramVarArgs.aS(5, this.duh);
      paramVarArgs.z(6, this.dAp);
      paramVarArgs.z(7, this.dyz);
      if (this.objectNonceId != null) {
        paramVarArgs.d(8, this.objectNonceId);
      }
      if (this.GmY != null) {
        paramVarArgs.d(9, this.GmY);
      }
      paramVarArgs.aS(10, this.scene);
      if (this.GmZ != null) {
        paramVarArgs.d(11, this.GmZ);
      }
      if (this.rJv != null)
      {
        paramVarArgs.lC(12, this.rJv.computeSize());
        this.rJv.writeFields(paramVarArgs);
      }
      if (this.Gna != null)
      {
        paramVarArgs.lC(13, this.Gna.computeSize());
        this.Gna.writeFields(paramVarArgs);
      }
      if (this.rKC != null) {
        paramVarArgs.c(14, this.rKC);
      }
      if (this.Gnb != null)
      {
        paramVarArgs.lC(15, this.Gnb.computeSize());
        this.Gnb.writeFields(paramVarArgs);
      }
      if (this.dHm != null) {
        paramVarArgs.d(16, this.dHm);
      }
      if (this.dHz != null) {
        paramVarArgs.d(17, this.dHz);
      }
      if (this.Gnc != null)
      {
        paramVarArgs.lC(18, this.Gnc.computeSize());
        this.Gnc.writeFields(paramVarArgs);
      }
      if (this.Oez != null) {
        paramVarArgs.d(19, this.Oez);
      }
      AppMethodBeat.o(209319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1800;
      }
    }
    label1800:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gle != null) {
        paramInt = i + f.a.a.a.lB(2, this.Gle.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = i + f.a.a.b.b.a.p(4, this.rIZ) + f.a.a.b.b.a.bz(5, this.duh) + f.a.a.b.b.a.alU(6) + f.a.a.b.b.a.alU(7);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.objectNonceId);
      }
      i = paramInt;
      if (this.GmY != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GmY);
      }
      i += f.a.a.b.b.a.bz(10, this.scene);
      paramInt = i;
      if (this.GmZ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GmZ);
      }
      i = paramInt;
      if (this.rJv != null) {
        i = paramInt + f.a.a.a.lB(12, this.rJv.computeSize());
      }
      paramInt = i;
      if (this.Gna != null) {
        paramInt = i + f.a.a.a.lB(13, this.Gna.computeSize());
      }
      i = paramInt;
      if (this.rKC != null) {
        i = paramInt + f.a.a.b.b.a.b(14, this.rKC);
      }
      paramInt = i;
      if (this.Gnb != null) {
        paramInt = i + f.a.a.a.lB(15, this.Gnb.computeSize());
      }
      i = paramInt;
      if (this.dHm != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.dHm);
      }
      paramInt = i;
      if (this.dHz != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.dHz);
      }
      i = paramInt;
      if (this.Gnc != null) {
        i = paramInt + f.a.a.a.lB(18, this.Gnc.computeSize());
      }
      paramInt = i;
      if (this.Oez != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.Oez);
      }
      AppMethodBeat.o(209319);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoj localaoj = (aoj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209319);
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
            localaoj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209319);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.Gle = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209319);
          return 0;
        case 3: 
          localaoj.lastBuffer = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(209319);
          return 0;
        case 4: 
          localaoj.rIZ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(209319);
          return 0;
        case 5: 
          localaoj.duh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209319);
          return 0;
        case 6: 
          localaoj.dAp = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(209319);
          return 0;
        case 7: 
          localaoj.dyz = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(209319);
          return 0;
        case 8: 
          localaoj.objectNonceId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209319);
          return 0;
        case 9: 
          localaoj.GmY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209319);
          return 0;
        case 10: 
          localaoj.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209319);
          return 0;
        case 11: 
          localaoj.GmZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209319);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.rJv = ((arg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209319);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new all();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((all)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.Gna = ((all)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209319);
          return 0;
        case 14: 
          localaoj.rKC = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(209319);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aln();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aln)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.Gnb = ((aln)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209319);
          return 0;
        case 16: 
          localaoj.dHm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209319);
          return 0;
        case 17: 
          localaoj.dHz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209319);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aoi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoj.Gnc = ((aoi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209319);
          return 0;
        }
        localaoj.Oez = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(209319);
        return 0;
      }
      AppMethodBeat.o(209319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoj
 * JD-Core Version:    0.7.0.1
 */