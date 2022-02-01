package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ow
  extends com.tencent.mm.bx.a
{
  public String YRK;
  public int YRL;
  public String YRO;
  public String YRR;
  public LinkedList<ox> YRZ;
  public int YSa;
  public String mef;
  public int ver;
  public String wwH;
  
  public ow()
  {
    AppMethodBeat.i(258183);
    this.YRZ = new LinkedList();
    AppMethodBeat.o(258183);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124425);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRR != null) {
        paramVarArgs.g(1, this.YRR);
      }
      if (this.wwH != null) {
        paramVarArgs.g(2, this.wwH);
      }
      paramVarArgs.bS(3, this.ver);
      if (this.YRK != null) {
        paramVarArgs.g(4, this.YRK);
      }
      if (this.mef != null) {
        paramVarArgs.g(5, this.mef);
      }
      paramVarArgs.bS(6, this.YRL);
      if (this.YRO != null) {
        paramVarArgs.g(7, this.YRO);
      }
      paramVarArgs.e(8, 8, this.YRZ);
      paramVarArgs.bS(9, this.YSa);
      AppMethodBeat.o(124425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRR == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = i.a.a.b.b.a.h(1, this.YRR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wwH != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wwH);
      }
      i += i.a.a.b.b.a.cJ(3, this.ver);
      paramInt = i;
      if (this.YRK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YRK);
      }
      i = paramInt;
      if (this.mef != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.mef);
      }
      i += i.a.a.b.b.a.cJ(6, this.YRL);
      paramInt = i;
      if (this.YRO != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YRO);
      }
      i = i.a.a.a.c(8, 8, this.YRZ);
      int j = i.a.a.b.b.a.cJ(9, this.YSa);
      AppMethodBeat.o(124425);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YRZ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ow localow = (ow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124425);
          return -1;
        case 1: 
          localow.YRR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 2: 
          localow.wwH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 3: 
          localow.ver = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124425);
          return 0;
        case 4: 
          localow.YRK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 5: 
          localow.mef = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 6: 
          localow.YRL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124425);
          return 0;
        case 7: 
          localow.YRO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ox localox = new ox();
            if ((localObject != null) && (localObject.length > 0)) {
              localox.parseFrom((byte[])localObject);
            }
            localow.YRZ.add(localox);
            paramInt += 1;
          }
          AppMethodBeat.o(124425);
          return 0;
        }
        localow.YSa = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124425);
        return 0;
      }
      AppMethodBeat.o(124425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ow
 * JD-Core Version:    0.7.0.1
 */