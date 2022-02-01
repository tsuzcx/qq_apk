package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class btx
  extends com.tencent.mm.bx.a
{
  public String YIZ;
  public FinderJumpInfo ZNl;
  public String aabE;
  public int aabF;
  public int aabG;
  public long aabH;
  public int aabI;
  public b aabJ;
  public int aabK;
  public int aabL;
  public String aabM;
  public String aabN;
  public int aabO;
  public bcd aabP;
  public int aabQ;
  public long object_id;
  public String object_nonce_id;
  public b tabTipsByPassInfo;
  public int tab_type;
  public int update_time;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259332);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aabE != null) {
        paramVarArgs.g(1, this.aabE);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      paramVarArgs.bS(3, this.aabF);
      paramVarArgs.bv(4, this.object_id);
      paramVarArgs.bS(5, this.aabG);
      paramVarArgs.bS(6, this.update_time);
      paramVarArgs.bv(7, this.aabH);
      if (this.tabTipsByPassInfo != null) {
        paramVarArgs.d(8, this.tabTipsByPassInfo);
      }
      if (this.object_nonce_id != null) {
        paramVarArgs.g(9, this.object_nonce_id);
      }
      paramVarArgs.bS(10, this.tab_type);
      paramVarArgs.bS(11, this.aabI);
      if (this.aabJ != null) {
        paramVarArgs.d(12, this.aabJ);
      }
      paramVarArgs.bS(13, this.aabK);
      paramVarArgs.bS(14, this.aabL);
      if (this.YIZ != null) {
        paramVarArgs.g(15, this.YIZ);
      }
      if (this.aabM != null) {
        paramVarArgs.g(16, this.aabM);
      }
      if (this.aabN != null) {
        paramVarArgs.g(17, this.aabN);
      }
      paramVarArgs.bS(18, this.aabO);
      if (this.aabP != null)
      {
        paramVarArgs.qD(19, this.aabP.computeSize());
        this.aabP.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(22, this.aabQ);
      if (this.ZNl != null)
      {
        paramVarArgs.qD(23, this.ZNl.computeSize());
        this.ZNl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aabE == null) {
        break label1410;
      }
    }
    label1410:
    for (paramInt = i.a.a.b.b.a.h(1, this.aabE) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.username);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aabF) + i.a.a.b.b.a.q(4, this.object_id) + i.a.a.b.b.a.cJ(5, this.aabG) + i.a.a.b.b.a.cJ(6, this.update_time) + i.a.a.b.b.a.q(7, this.aabH);
      paramInt = i;
      if (this.tabTipsByPassInfo != null) {
        paramInt = i + i.a.a.b.b.a.c(8, this.tabTipsByPassInfo);
      }
      i = paramInt;
      if (this.object_nonce_id != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.object_nonce_id);
      }
      i = i + i.a.a.b.b.a.cJ(10, this.tab_type) + i.a.a.b.b.a.cJ(11, this.aabI);
      paramInt = i;
      if (this.aabJ != null) {
        paramInt = i + i.a.a.b.b.a.c(12, this.aabJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.aabK) + i.a.a.b.b.a.cJ(14, this.aabL);
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.YIZ);
      }
      i = paramInt;
      if (this.aabM != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.aabM);
      }
      paramInt = i;
      if (this.aabN != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.aabN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(18, this.aabO);
      paramInt = i;
      if (this.aabP != null) {
        paramInt = i + i.a.a.a.qC(19, this.aabP.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.aabQ);
      paramInt = i;
      if (this.ZNl != null) {
        paramInt = i + i.a.a.a.qC(23, this.ZNl.computeSize());
      }
      AppMethodBeat.o(259332);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259332);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        btx localbtx = (btx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 20: 
        case 21: 
        default: 
          AppMethodBeat.o(259332);
          return -1;
        case 1: 
          localbtx.aabE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259332);
          return 0;
        case 2: 
          localbtx.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259332);
          return 0;
        case 3: 
          localbtx.aabF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259332);
          return 0;
        case 4: 
          localbtx.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259332);
          return 0;
        case 5: 
          localbtx.aabG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259332);
          return 0;
        case 6: 
          localbtx.update_time = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259332);
          return 0;
        case 7: 
          localbtx.aabH = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259332);
          return 0;
        case 8: 
          localbtx.tabTipsByPassInfo = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259332);
          return 0;
        case 9: 
          localbtx.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259332);
          return 0;
        case 10: 
          localbtx.tab_type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259332);
          return 0;
        case 11: 
          localbtx.aabI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259332);
          return 0;
        case 12: 
          localbtx.aabJ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259332);
          return 0;
        case 13: 
          localbtx.aabK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259332);
          return 0;
        case 14: 
          localbtx.aabL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259332);
          return 0;
        case 15: 
          localbtx.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259332);
          return 0;
        case 16: 
          localbtx.aabM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259332);
          return 0;
        case 17: 
          localbtx.aabN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259332);
          return 0;
        case 18: 
          localbtx.aabO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259332);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcd)localObject2).parseFrom((byte[])localObject1);
            }
            localbtx.aabP = ((bcd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259332);
          return 0;
        case 22: 
          localbtx.aabQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259332);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderJumpInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderJumpInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localbtx.ZNl = ((FinderJumpInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259332);
        return 0;
      }
      AppMethodBeat.o(259332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btx
 * JD-Core Version:    0.7.0.1
 */