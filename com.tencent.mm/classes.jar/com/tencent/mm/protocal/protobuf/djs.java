package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class djs
  extends com.tencent.mm.bx.a
{
  public int Jjm;
  public LinkedList<djt> aaPE;
  public LinkedList<djt> aaPF;
  public djt aaPG;
  public int aaPH;
  public long hTh;
  public String key;
  
  public djs()
  {
    AppMethodBeat.i(259763);
    this.aaPE = new LinkedList();
    this.aaPF = new LinkedList();
    AppMethodBeat.o(259763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259771);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aaPE);
      paramVarArgs.e(2, 8, this.aaPF);
      if (this.aaPG != null)
      {
        paramVarArgs.qD(3, this.aaPG.computeSize());
        this.aaPG.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.Jjm);
      paramVarArgs.bS(5, this.aaPH);
      paramVarArgs.bv(6, this.hTh);
      if (this.key != null) {
        paramVarArgs.g(7, this.key);
      }
      AppMethodBeat.o(259771);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.aaPE) + 0 + i.a.a.a.c(2, 8, this.aaPF);
      paramInt = i;
      if (this.aaPG != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaPG.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.Jjm) + i.a.a.b.b.a.cJ(5, this.aaPH) + i.a.a.b.b.a.q(6, this.hTh);
      paramInt = i;
      if (this.key != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.key);
      }
      AppMethodBeat.o(259771);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaPE.clear();
      this.aaPF.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259771);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      djs localdjs = (djs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      djt localdjt;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259771);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdjt = new djt();
          if ((localObject != null) && (localObject.length > 0)) {
            localdjt.parseFrom((byte[])localObject);
          }
          localdjs.aaPE.add(localdjt);
          paramInt += 1;
        }
        AppMethodBeat.o(259771);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdjt = new djt();
          if ((localObject != null) && (localObject.length > 0)) {
            localdjt.parseFrom((byte[])localObject);
          }
          localdjs.aaPF.add(localdjt);
          paramInt += 1;
        }
        AppMethodBeat.o(259771);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdjt = new djt();
          if ((localObject != null) && (localObject.length > 0)) {
            localdjt.parseFrom((byte[])localObject);
          }
          localdjs.aaPG = localdjt;
          paramInt += 1;
        }
        AppMethodBeat.o(259771);
        return 0;
      case 4: 
        localdjs.Jjm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259771);
        return 0;
      case 5: 
        localdjs.aaPH = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259771);
        return 0;
      case 6: 
        localdjs.hTh = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259771);
        return 0;
      }
      localdjs.key = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(259771);
      return 0;
    }
    AppMethodBeat.o(259771);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djs
 * JD-Core Version:    0.7.0.1
 */