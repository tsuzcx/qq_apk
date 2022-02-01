package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class btl
  extends com.tencent.mm.bx.a
{
  public String GOc;
  public SKBuiltinBuffer_t GOd;
  public int GOe;
  public int GOf;
  public String Title;
  public int nEf;
  public String wpM;
  public float wpN;
  public int wpO;
  public LinkedList<Integer> wpP;
  public int wpQ;
  public LinkedList<cwt> wpR;
  public float wpS;
  public String wpT;
  public SKBuiltinBuffer_t wpU;
  
  public btl()
  {
    AppMethodBeat.i(116338);
    this.wpP = new LinkedList();
    this.wpR = new LinkedList();
    AppMethodBeat.o(116338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116339);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wpM != null) {
        paramVarArgs.d(1, this.wpM);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.z(3, this.wpN);
      paramVarArgs.aS(4, this.wpO);
      paramVarArgs.f(5, 2, this.wpP);
      paramVarArgs.aS(6, this.wpQ);
      paramVarArgs.e(7, 8, this.wpR);
      paramVarArgs.z(8, this.wpS);
      if (this.wpT != null) {
        paramVarArgs.d(9, this.wpT);
      }
      paramVarArgs.aS(10, this.nEf);
      if (this.wpU != null)
      {
        paramVarArgs.lC(11, this.wpU.computeSize());
        this.wpU.writeFields(paramVarArgs);
      }
      if (this.GOc != null) {
        paramVarArgs.d(12, this.GOc);
      }
      if (this.GOd != null)
      {
        paramVarArgs.lC(13, this.GOd.computeSize());
        this.GOd.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.GOe);
      paramVarArgs.aS(15, this.GOf);
      AppMethodBeat.o(116339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wpM == null) {
        break label1235;
      }
    }
    label1235:
    for (paramInt = f.a.a.b.b.a.e(1, this.wpM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      i = i + f.a.a.b.b.a.alU(3) + f.a.a.b.b.a.bz(4, this.wpO) + f.a.a.a.d(5, 2, this.wpP) + f.a.a.b.b.a.bz(6, this.wpQ) + f.a.a.a.c(7, 8, this.wpR) + f.a.a.b.b.a.alU(8);
      paramInt = i;
      if (this.wpT != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.wpT);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.nEf);
      paramInt = i;
      if (this.wpU != null) {
        paramInt = i + f.a.a.a.lB(11, this.wpU.computeSize());
      }
      i = paramInt;
      if (this.GOc != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GOc);
      }
      paramInt = i;
      if (this.GOd != null) {
        paramInt = i + f.a.a.a.lB(13, this.GOd.computeSize());
      }
      i = f.a.a.b.b.a.bz(14, this.GOe);
      int j = f.a.a.b.b.a.bz(15, this.GOf);
      AppMethodBeat.o(116339);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wpP.clear();
        this.wpR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btl localbtl = (btl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116339);
          return -1;
        case 1: 
          localbtl.wpM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 2: 
          localbtl.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 3: 
          localbtl.wpN = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(116339);
          return 0;
        case 4: 
          localbtl.wpO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116339);
          return 0;
        case 5: 
          localbtl.wpP = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
          AppMethodBeat.o(116339);
          return 0;
        case 6: 
          localbtl.wpQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116339);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtl.wpR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 8: 
          localbtl.wpS = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(116339);
          return 0;
        case 9: 
          localbtl.wpT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 10: 
          localbtl.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116339);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtl.wpU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 12: 
          localbtl.GOc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtl.GOd = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 14: 
          localbtl.GOe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116339);
          return 0;
        }
        localbtl.GOf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(116339);
        return 0;
      }
      AppMethodBeat.o(116339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btl
 * JD-Core Version:    0.7.0.1
 */