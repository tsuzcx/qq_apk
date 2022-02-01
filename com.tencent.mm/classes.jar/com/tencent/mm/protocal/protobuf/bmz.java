package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmz
  extends com.tencent.mm.bx.a
{
  public bnb ENu;
  public FinderObject ZIo;
  public long ZVF;
  public bnc ZVG;
  public LinkedList<FinderObject> ZVH;
  public atw ZVI;
  public String ZVJ;
  public blx ZVK;
  public ath ZVL;
  public int style;
  public String ttL;
  
  public bmz()
  {
    AppMethodBeat.i(258889);
    this.ZVH = new LinkedList();
    AppMethodBeat.o(258889);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258897);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZVF);
      paramVarArgs.bS(2, this.style);
      if (this.ZIo != null)
      {
        paramVarArgs.qD(3, this.ZIo.computeSize());
        this.ZIo.writeFields(paramVarArgs);
      }
      if (this.ttL != null) {
        paramVarArgs.g(4, this.ttL);
      }
      if (this.ZVG != null)
      {
        paramVarArgs.qD(5, this.ZVG.computeSize());
        this.ZVG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.ZVH);
      if (this.ENu != null)
      {
        paramVarArgs.qD(7, this.ENu.computeSize());
        this.ENu.writeFields(paramVarArgs);
      }
      if (this.ZVI != null)
      {
        paramVarArgs.qD(8, this.ZVI.computeSize());
        this.ZVI.writeFields(paramVarArgs);
      }
      if (this.ZVJ != null) {
        paramVarArgs.g(9, this.ZVJ);
      }
      if (this.ZVK != null)
      {
        paramVarArgs.qD(10, this.ZVK.computeSize());
        this.ZVK.writeFields(paramVarArgs);
      }
      if (this.ZVL != null)
      {
        paramVarArgs.qD(11, this.ZVL.computeSize());
        this.ZVL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258897);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.ZVF) + 0 + i.a.a.b.b.a.cJ(2, this.style);
      paramInt = i;
      if (this.ZIo != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZIo.computeSize());
      }
      i = paramInt;
      if (this.ttL != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ttL);
      }
      paramInt = i;
      if (this.ZVG != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZVG.computeSize());
      }
      i = paramInt + i.a.a.a.c(6, 8, this.ZVH);
      paramInt = i;
      if (this.ENu != null) {
        paramInt = i + i.a.a.a.qC(7, this.ENu.computeSize());
      }
      i = paramInt;
      if (this.ZVI != null) {
        i = paramInt + i.a.a.a.qC(8, this.ZVI.computeSize());
      }
      paramInt = i;
      if (this.ZVJ != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZVJ);
      }
      i = paramInt;
      if (this.ZVK != null) {
        i = paramInt + i.a.a.a.qC(10, this.ZVK.computeSize());
      }
      paramInt = i;
      if (this.ZVL != null) {
        paramInt = i + i.a.a.a.qC(11, this.ZVL.computeSize());
      }
      AppMethodBeat.o(258897);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZVH.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258897);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bmz localbmz = (bmz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258897);
        return -1;
      case 1: 
        localbmz.ZVF = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258897);
        return 0;
      case 2: 
        localbmz.style = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258897);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderObject)localObject2).parseFrom((byte[])localObject1);
          }
          localbmz.ZIo = ((FinderObject)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258897);
        return 0;
      case 4: 
        localbmz.ttL = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258897);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bnc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bnc)localObject2).parseFrom((byte[])localObject1);
          }
          localbmz.ZVG = ((bnc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258897);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderObject)localObject2).parseFrom((byte[])localObject1);
          }
          localbmz.ZVH.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258897);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bnb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bnb)localObject2).parseFrom((byte[])localObject1);
          }
          localbmz.ENu = ((bnb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258897);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new atw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((atw)localObject2).parseFrom((byte[])localObject1);
          }
          localbmz.ZVI = ((atw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258897);
        return 0;
      case 9: 
        localbmz.ZVJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258897);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new blx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((blx)localObject2).parseFrom((byte[])localObject1);
          }
          localbmz.ZVK = ((blx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258897);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ath();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ath)localObject2).parseFrom((byte[])localObject1);
        }
        localbmz.ZVL = ((ath)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258897);
      return 0;
    }
    AppMethodBeat.o(258897);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmz
 * JD-Core Version:    0.7.0.1
 */