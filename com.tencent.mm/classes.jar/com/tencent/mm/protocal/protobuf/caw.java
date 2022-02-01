package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class caw
  extends com.tencent.mm.bx.a
{
  public LinkedList<ezb> aajS;
  public ezb aajT;
  public LinkedList<cav> aajU;
  public boolean aajV;
  public String aajW;
  public long aajX;
  public String hQR;
  public boolean lAr;
  
  public caw()
  {
    AppMethodBeat.i(122501);
    this.aajS = new LinkedList();
    this.aajU = new LinkedList();
    this.aajV = false;
    this.lAr = false;
    AppMethodBeat.o(122501);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122502);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hQR != null) {
        paramVarArgs.g(1, this.hQR);
      }
      paramVarArgs.e(2, 8, this.aajS);
      if (this.aajT != null)
      {
        paramVarArgs.qD(3, this.aajT.computeSize());
        this.aajT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.aajU);
      paramVarArgs.di(5, this.aajV);
      paramVarArgs.di(6, this.lAr);
      if (this.aajW != null) {
        paramVarArgs.g(7, this.aajW);
      }
      paramVarArgs.bv(8, this.aajX);
      AppMethodBeat.o(122502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hQR == null) {
        break label772;
      }
    }
    label772:
    for (paramInt = i.a.a.b.b.a.h(1, this.hQR) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aajS);
      paramInt = i;
      if (this.aajT != null) {
        paramInt = i + i.a.a.a.qC(3, this.aajT.computeSize());
      }
      i = paramInt + i.a.a.a.c(4, 8, this.aajU) + (i.a.a.b.b.a.ko(5) + 1) + (i.a.a.b.b.a.ko(6) + 1);
      paramInt = i;
      if (this.aajW != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aajW);
      }
      i = i.a.a.b.b.a.q(8, this.aajX);
      AppMethodBeat.o(122502);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aajS.clear();
        this.aajU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        caw localcaw = (caw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122502);
          return -1;
        case 1: 
          localcaw.hQR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(122502);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ezb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ezb)localObject2).parseFrom((byte[])localObject1);
            }
            localcaw.aajS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ezb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ezb)localObject2).parseFrom((byte[])localObject1);
            }
            localcaw.aajT = ((ezb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cav();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cav)localObject2).parseFrom((byte[])localObject1);
            }
            localcaw.aajU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 5: 
          localcaw.aajV = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(122502);
          return 0;
        case 6: 
          localcaw.lAr = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(122502);
          return 0;
        case 7: 
          localcaw.aajW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(122502);
          return 0;
        }
        localcaw.aajX = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(122502);
        return 0;
      }
      AppMethodBeat.o(122502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caw
 * JD-Core Version:    0.7.0.1
 */