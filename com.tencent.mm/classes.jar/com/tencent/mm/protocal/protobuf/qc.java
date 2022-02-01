package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qc
  extends erp
{
  public LinkedList<pz> YUB;
  public int YUC;
  public int YUD;
  public int YUE;
  public int YUF;
  public int YUG;
  public qa YUH;
  public int YUI;
  public int YUJ;
  public int YUK;
  public String YUL;
  public pz YUM;
  public int YUN;
  public String YUO;
  public String igg;
  public int scene;
  
  public qc()
  {
    AppMethodBeat.i(124438);
    this.YUB = new LinkedList();
    this.YUC = 1;
    AppMethodBeat.o(124438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124439);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YUB);
      paramVarArgs.bS(3, this.scene);
      paramVarArgs.bS(4, this.YUC);
      paramVarArgs.bS(5, this.YUD);
      if (this.igg != null) {
        paramVarArgs.g(6, this.igg);
      }
      paramVarArgs.bS(7, this.YUE);
      paramVarArgs.bS(8, this.YUF);
      paramVarArgs.bS(9, this.YUG);
      if (this.YUH != null)
      {
        paramVarArgs.qD(10, this.YUH.computeSize());
        this.YUH.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.YUI);
      paramVarArgs.bS(12, this.YUJ);
      paramVarArgs.bS(13, this.YUK);
      if (this.YUL != null) {
        paramVarArgs.g(14, this.YUL);
      }
      if (this.YUM != null)
      {
        paramVarArgs.qD(15, this.YUM.computeSize());
        this.YUM.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(17, this.YUN);
      if (this.YUO != null) {
        paramVarArgs.g(18, this.YUO);
      }
      AppMethodBeat.o(124439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1302;
      }
    }
    label1302:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YUB) + i.a.a.b.b.a.cJ(3, this.scene) + i.a.a.b.b.a.cJ(4, this.YUC) + i.a.a.b.b.a.cJ(5, this.YUD);
      paramInt = i;
      if (this.igg != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.igg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.YUE) + i.a.a.b.b.a.cJ(8, this.YUF) + i.a.a.b.b.a.cJ(9, this.YUG);
      paramInt = i;
      if (this.YUH != null) {
        paramInt = i + i.a.a.a.qC(10, this.YUH.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.YUI) + i.a.a.b.b.a.cJ(12, this.YUJ) + i.a.a.b.b.a.cJ(13, this.YUK);
      paramInt = i;
      if (this.YUL != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.YUL);
      }
      i = paramInt;
      if (this.YUM != null) {
        i = paramInt + i.a.a.a.qC(15, this.YUM.computeSize());
      }
      i += i.a.a.b.b.a.cJ(17, this.YUN);
      paramInt = i;
      if (this.YUO != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.YUO);
      }
      AppMethodBeat.o(124439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YUB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        qc localqc = (qc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 16: 
        default: 
          AppMethodBeat.o(124439);
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
            localqc.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124439);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new pz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((pz)localObject2).parseFrom((byte[])localObject1);
            }
            localqc.YUB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124439);
          return 0;
        case 3: 
          localqc.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124439);
          return 0;
        case 4: 
          localqc.YUC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124439);
          return 0;
        case 5: 
          localqc.YUD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124439);
          return 0;
        case 6: 
          localqc.igg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124439);
          return 0;
        case 7: 
          localqc.YUE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124439);
          return 0;
        case 8: 
          localqc.YUF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124439);
          return 0;
        case 9: 
          localqc.YUG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124439);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qa)localObject2).parseFrom((byte[])localObject1);
            }
            localqc.YUH = ((qa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124439);
          return 0;
        case 11: 
          localqc.YUI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124439);
          return 0;
        case 12: 
          localqc.YUJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124439);
          return 0;
        case 13: 
          localqc.YUK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124439);
          return 0;
        case 14: 
          localqc.YUL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124439);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new pz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((pz)localObject2).parseFrom((byte[])localObject1);
            }
            localqc.YUM = ((pz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124439);
          return 0;
        case 17: 
          localqc.YUN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124439);
          return 0;
        }
        localqc.YUO = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(124439);
        return 0;
      }
      AppMethodBeat.o(124439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qc
 * JD-Core Version:    0.7.0.1
 */