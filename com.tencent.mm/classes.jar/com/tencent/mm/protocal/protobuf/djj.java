package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class djj
  extends com.tencent.mm.bx.a
{
  public int EUp;
  public long Frl;
  public LinkedList<djg> aaPA;
  public epm aaPB;
  public int aaPu;
  public LinkedList<dji> aaPv;
  public int aaPw;
  public long aaPx;
  public long aaPy;
  public long aaPz;
  public String clientId;
  public long mnY;
  public int nrQ;
  public int postStage;
  
  public djj()
  {
    AppMethodBeat.i(169081);
    this.aaPv = new LinkedList();
    this.aaPA = new LinkedList();
    AppMethodBeat.o(169081);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169082);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.clientId != null) {
        paramVarArgs.g(1, this.clientId);
      }
      paramVarArgs.bS(2, this.nrQ);
      paramVarArgs.bS(3, this.aaPu);
      paramVarArgs.e(4, 8, this.aaPv);
      paramVarArgs.bS(5, this.aaPw);
      paramVarArgs.bS(6, this.postStage);
      paramVarArgs.bv(7, this.aaPx);
      paramVarArgs.bv(8, this.Frl);
      paramVarArgs.bv(9, this.aaPy);
      paramVarArgs.bv(10, this.mnY);
      paramVarArgs.bv(11, this.aaPz);
      paramVarArgs.e(12, 8, this.aaPA);
      if (this.aaPB != null)
      {
        paramVarArgs.qD(13, this.aaPB.computeSize());
        this.aaPB.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.EUp);
      AppMethodBeat.o(169082);
      return 0;
    }
    if (paramInt == 1) {
      if (this.clientId == null) {
        break label1020;
      }
    }
    label1020:
    for (paramInt = i.a.a.b.b.a.h(1, this.clientId) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.nrQ) + i.a.a.b.b.a.cJ(3, this.aaPu) + i.a.a.a.c(4, 8, this.aaPv) + i.a.a.b.b.a.cJ(5, this.aaPw) + i.a.a.b.b.a.cJ(6, this.postStage) + i.a.a.b.b.a.q(7, this.aaPx) + i.a.a.b.b.a.q(8, this.Frl) + i.a.a.b.b.a.q(9, this.aaPy) + i.a.a.b.b.a.q(10, this.mnY) + i.a.a.b.b.a.q(11, this.aaPz) + i.a.a.a.c(12, 8, this.aaPA);
      paramInt = i;
      if (this.aaPB != null) {
        paramInt = i + i.a.a.a.qC(13, this.aaPB.computeSize());
      }
      i = i.a.a.b.b.a.cJ(14, this.EUp);
      AppMethodBeat.o(169082);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaPv.clear();
        this.aaPA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169082);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        djj localdjj = (djj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169082);
          return -1;
        case 1: 
          localdjj.clientId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(169082);
          return 0;
        case 2: 
          localdjj.nrQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169082);
          return 0;
        case 3: 
          localdjj.aaPu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169082);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dji();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dji)localObject2).parseFrom((byte[])localObject1);
            }
            localdjj.aaPv.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169082);
          return 0;
        case 5: 
          localdjj.aaPw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169082);
          return 0;
        case 6: 
          localdjj.postStage = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169082);
          return 0;
        case 7: 
          localdjj.aaPx = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169082);
          return 0;
        case 8: 
          localdjj.Frl = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169082);
          return 0;
        case 9: 
          localdjj.aaPy = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169082);
          return 0;
        case 10: 
          localdjj.mnY = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169082);
          return 0;
        case 11: 
          localdjj.aaPz = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(169082);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new djg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((djg)localObject2).parseFrom((byte[])localObject1);
            }
            localdjj.aaPA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169082);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epm)localObject2).parseFrom((byte[])localObject1);
            }
            localdjj.aaPB = ((epm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169082);
          return 0;
        }
        localdjj.EUp = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169082);
        return 0;
      }
      AppMethodBeat.o(169082);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djj
 * JD-Core Version:    0.7.0.1
 */