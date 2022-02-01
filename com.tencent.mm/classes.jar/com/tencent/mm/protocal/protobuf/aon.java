package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aon
  extends cvc
{
  public b GmG;
  public alk Gnf;
  public long Gng;
  public dog Gnh;
  public float dAp;
  public int duh;
  public float dyz;
  public String dzZ;
  public int ePx;
  public arg rJv;
  public int sMj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168990);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gnf != null)
      {
        paramVarArgs.lC(2, this.Gnf.computeSize());
        this.Gnf.writeFields(paramVarArgs);
      }
      if (this.GmG != null) {
        paramVarArgs.c(3, this.GmG);
      }
      paramVarArgs.aS(4, this.sMj);
      if (this.dzZ != null) {
        paramVarArgs.d(5, this.dzZ);
      }
      paramVarArgs.z(6, this.dAp);
      paramVarArgs.z(7, this.dyz);
      paramVarArgs.aY(8, this.Gng);
      paramVarArgs.aS(9, this.duh);
      if (this.Gnh != null)
      {
        paramVarArgs.lC(10, this.Gnh.computeSize());
        this.Gnh.writeFields(paramVarArgs);
      }
      if (this.rJv != null)
      {
        paramVarArgs.lC(11, this.rJv.computeSize());
        this.rJv.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.ePx);
      AppMethodBeat.o(168990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1164;
      }
    }
    label1164:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gnf != null) {
        paramInt = i + f.a.a.a.lB(2, this.Gnf.computeSize());
      }
      i = paramInt;
      if (this.GmG != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GmG);
      }
      i += f.a.a.b.b.a.bz(4, this.sMj);
      paramInt = i;
      if (this.dzZ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dzZ);
      }
      i = paramInt + f.a.a.b.b.a.alU(6) + f.a.a.b.b.a.alU(7) + f.a.a.b.b.a.p(8, this.Gng) + f.a.a.b.b.a.bz(9, this.duh);
      paramInt = i;
      if (this.Gnh != null) {
        paramInt = i + f.a.a.a.lB(10, this.Gnh.computeSize());
      }
      i = paramInt;
      if (this.rJv != null) {
        i = paramInt + f.a.a.a.lB(11, this.rJv.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(12, this.ePx);
      AppMethodBeat.o(168990);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168990);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aon localaon = (aon)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168990);
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
            localaon.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
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
            localaon.Gnf = ((alk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 3: 
          localaon.GmG = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(168990);
          return 0;
        case 4: 
          localaon.sMj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168990);
          return 0;
        case 5: 
          localaon.dzZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168990);
          return 0;
        case 6: 
          localaon.dAp = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(168990);
          return 0;
        case 7: 
          localaon.dyz = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(168990);
          return 0;
        case 8: 
          localaon.Gng = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(168990);
          return 0;
        case 9: 
          localaon.duh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168990);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dog();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dog)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaon.Gnh = ((dog)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaon.rJv = ((arg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        }
        localaon.ePx = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168990);
        return 0;
      }
      AppMethodBeat.o(168990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aon
 * JD-Core Version:    0.7.0.1
 */