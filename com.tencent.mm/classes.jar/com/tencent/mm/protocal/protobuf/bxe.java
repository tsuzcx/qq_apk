package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxe
  extends erp
{
  public atz CJv;
  public LinkedList<FinderContact> ZJH;
  public LinkedList<FinderContact> aabr;
  public gol aafS;
  public LinkedList<btw> aafT;
  public String aafU;
  public LinkedList<btw> aafV;
  public String aafW;
  public int aafX;
  public String aafY;
  public int aafZ;
  public long aaga;
  public bww aagb;
  public bwx aagc;
  public String finderUsername;
  public int scene;
  public int selector;
  
  public bxe()
  {
    AppMethodBeat.i(169060);
    this.ZJH = new LinkedList();
    this.aabr = new LinkedList();
    this.aafT = new LinkedList();
    this.aafV = new LinkedList();
    AppMethodBeat.o(169060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169061);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.selector);
      if (this.aafS != null)
      {
        paramVarArgs.qD(3, this.aafS.computeSize());
        this.aafS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.ZJH);
      paramVarArgs.e(5, 8, this.aabr);
      if (this.finderUsername != null) {
        paramVarArgs.g(6, this.finderUsername);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(7, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.scene);
      paramVarArgs.e(9, 8, this.aafT);
      if (this.aafU != null) {
        paramVarArgs.g(10, this.aafU);
      }
      paramVarArgs.e(11, 8, this.aafV);
      if (this.aafW != null) {
        paramVarArgs.g(12, this.aafW);
      }
      paramVarArgs.bS(13, this.aafX);
      if (this.aafY != null) {
        paramVarArgs.g(14, this.aafY);
      }
      paramVarArgs.bS(15, this.aafZ);
      paramVarArgs.bv(16, this.aaga);
      if (this.aagb != null)
      {
        paramVarArgs.qD(17, this.aagb.computeSize());
        this.aagb.writeFields(paramVarArgs);
      }
      if (this.aagc != null)
      {
        paramVarArgs.qD(18, this.aagc.computeSize());
        this.aagc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1764;
      }
    }
    label1764:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.selector);
      paramInt = i;
      if (this.aafS != null) {
        paramInt = i + i.a.a.a.qC(3, this.aafS.computeSize());
      }
      i = paramInt + i.a.a.a.c(4, 8, this.ZJH) + i.a.a.a.c(5, 8, this.aabr);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.finderUsername);
      }
      i = paramInt;
      if (this.CJv != null) {
        i = paramInt + i.a.a.a.qC(7, this.CJv.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(8, this.scene) + i.a.a.a.c(9, 8, this.aafT);
      paramInt = i;
      if (this.aafU != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aafU);
      }
      i = paramInt + i.a.a.a.c(11, 8, this.aafV);
      paramInt = i;
      if (this.aafW != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aafW);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.aafX);
      paramInt = i;
      if (this.aafY != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.aafY);
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.aafZ) + i.a.a.b.b.a.q(16, this.aaga);
      paramInt = i;
      if (this.aagb != null) {
        paramInt = i + i.a.a.a.qC(17, this.aagb.computeSize());
      }
      i = paramInt;
      if (this.aagc != null) {
        i = paramInt + i.a.a.a.qC(18, this.aagc.computeSize());
      }
      AppMethodBeat.o(169061);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZJH.clear();
        this.aabr.clear();
        this.aafT.clear();
        this.aafV.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bxe localbxe = (bxe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169061);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbxe.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 2: 
          localbxe.selector = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169061);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localbxe.aafS = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbxe.ZJH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbxe.aabr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 6: 
          localbxe.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169061);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbxe.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 8: 
          localbxe.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169061);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new btw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((btw)localObject2).parseFrom((byte[])localObject1);
            }
            localbxe.aafT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 10: 
          localbxe.aafU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169061);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new btw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((btw)localObject2).parseFrom((byte[])localObject1);
            }
            localbxe.aafV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 12: 
          localbxe.aafW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169061);
          return 0;
        case 13: 
          localbxe.aafX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169061);
          return 0;
        case 14: 
          localbxe.aafY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169061);
          return 0;
        case 15: 
          localbxe.aafZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169061);
          return 0;
        case 16: 
          localbxe.aaga = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169061);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bww();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bww)localObject2).parseFrom((byte[])localObject1);
            }
            localbxe.aagb = ((bww)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwx)localObject2).parseFrom((byte[])localObject1);
          }
          localbxe.aagc = ((bwx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169061);
        return 0;
      }
      AppMethodBeat.o(169061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxe
 * JD-Core Version:    0.7.0.1
 */