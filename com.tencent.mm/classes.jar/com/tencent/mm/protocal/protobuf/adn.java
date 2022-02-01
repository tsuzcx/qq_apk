package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class adn
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t KHp;
  public String LoE;
  public String LoF;
  public int LoG;
  public int LoH;
  public String LoI;
  public int LoJ;
  public String LoK;
  public String LoL;
  public int LoM;
  public int LoN;
  public LinkedList<dpt> LoO;
  public String LoP;
  public int LoQ;
  public int LoR;
  public int LoS;
  public int LoT;
  public String UserName;
  public int kdY;
  public String ked;
  public String oUJ;
  public String xNU;
  
  public adn()
  {
    AppMethodBeat.i(32174);
    this.LoO = new LinkedList();
    AppMethodBeat.o(32174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32175);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(32175);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.LoE != null) {
        paramVarArgs.e(3, this.LoE);
      }
      if (this.LoF != null) {
        paramVarArgs.e(4, this.LoF);
      }
      paramVarArgs.aM(5, this.kdY);
      if (this.KHp != null)
      {
        paramVarArgs.ni(6, this.KHp.computeSize());
        this.KHp.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.LoG);
      paramVarArgs.aM(8, this.LoH);
      if (this.LoI != null) {
        paramVarArgs.e(9, this.LoI);
      }
      paramVarArgs.aM(10, this.LoJ);
      if (this.LoK != null) {
        paramVarArgs.e(11, this.LoK);
      }
      if (this.LoL != null) {
        paramVarArgs.e(12, this.LoL);
      }
      paramVarArgs.aM(13, this.LoM);
      paramVarArgs.aM(14, this.LoN);
      paramVarArgs.e(15, 8, this.LoO);
      if (this.LoP != null) {
        paramVarArgs.e(16, this.LoP);
      }
      paramVarArgs.aM(17, this.LoQ);
      paramVarArgs.aM(18, this.LoR);
      if (this.xNU != null) {
        paramVarArgs.e(19, this.xNU);
      }
      paramVarArgs.aM(20, this.LoS);
      paramVarArgs.aM(21, this.LoT);
      if (this.ked != null) {
        paramVarArgs.e(22, this.ked);
      }
      AppMethodBeat.o(32175);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1594;
      }
    }
    label1594:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.LoE != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LoE);
      }
      paramInt = i;
      if (this.LoF != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LoF);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.kdY);
      paramInt = i;
      if (this.KHp != null) {
        paramInt = i + g.a.a.a.nh(6, this.KHp.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.LoG) + g.a.a.b.b.a.bu(8, this.LoH);
      paramInt = i;
      if (this.LoI != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LoI);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.LoJ);
      paramInt = i;
      if (this.LoK != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LoK);
      }
      i = paramInt;
      if (this.LoL != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.LoL);
      }
      i = i + g.a.a.b.b.a.bu(13, this.LoM) + g.a.a.b.b.a.bu(14, this.LoN) + g.a.a.a.c(15, 8, this.LoO);
      paramInt = i;
      if (this.LoP != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.LoP);
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.LoQ) + g.a.a.b.b.a.bu(18, this.LoR);
      paramInt = i;
      if (this.xNU != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.xNU);
      }
      i = paramInt + g.a.a.b.b.a.bu(20, this.LoS) + g.a.a.b.b.a.bu(21, this.LoT);
      paramInt = i;
      if (this.ked != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.ked);
      }
      AppMethodBeat.o(32175);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LoO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KHp == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(32175);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32175);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        adn localadn = (adn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32175);
          return -1;
        case 1: 
          localadn.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 2: 
          localadn.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 3: 
          localadn.LoE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 4: 
          localadn.LoF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 5: 
          localadn.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32175);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localadn.KHp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 7: 
          localadn.LoG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32175);
          return 0;
        case 8: 
          localadn.LoH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32175);
          return 0;
        case 9: 
          localadn.LoI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 10: 
          localadn.LoJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32175);
          return 0;
        case 11: 
          localadn.LoK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 12: 
          localadn.LoL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 13: 
          localadn.LoM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32175);
          return 0;
        case 14: 
          localadn.LoN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32175);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localadn.LoO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 16: 
          localadn.LoP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 17: 
          localadn.LoQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32175);
          return 0;
        case 18: 
          localadn.LoR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32175);
          return 0;
        case 19: 
          localadn.xNU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 20: 
          localadn.LoS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32175);
          return 0;
        case 21: 
          localadn.LoT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32175);
          return 0;
        }
        localadn.ked = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32175);
        return 0;
      }
      AppMethodBeat.o(32175);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adn
 * JD-Core Version:    0.7.0.1
 */