package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aco
  extends com.tencent.mm.bx.a
{
  public LinkedList<dfk> IIU;
  public int YMr;
  public int ZkT;
  public String mut;
  public String muu;
  public String muv;
  public String muw;
  public String mux;
  public int vhO;
  public int yth;
  
  public aco()
  {
    AppMethodBeat.i(143965);
    this.IIU = new LinkedList();
    AppMethodBeat.o(143965);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143966);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.yth);
      if (this.muv != null) {
        paramVarArgs.g(7, this.muv);
      }
      paramVarArgs.bS(2, this.YMr);
      paramVarArgs.bS(3, this.ZkT);
      paramVarArgs.e(4, 8, this.IIU);
      if (this.mut != null) {
        paramVarArgs.g(5, this.mut);
      }
      if (this.muu != null) {
        paramVarArgs.g(6, this.muu);
      }
      if (this.muw != null) {
        paramVarArgs.g(8, this.muw);
      }
      if (this.mux != null) {
        paramVarArgs.g(9, this.mux);
      }
      paramVarArgs.bS(10, this.vhO);
      AppMethodBeat.o(143966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.yth) + 0;
      paramInt = i;
      if (this.muv != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.muv);
      }
      i = paramInt + i.a.a.b.b.a.cJ(2, this.YMr) + i.a.a.b.b.a.cJ(3, this.ZkT) + i.a.a.a.c(4, 8, this.IIU);
      paramInt = i;
      if (this.mut != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.mut);
      }
      i = paramInt;
      if (this.muu != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.muu);
      }
      paramInt = i;
      if (this.muw != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.muw);
      }
      i = paramInt;
      if (this.mux != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.mux);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.vhO);
      AppMethodBeat.o(143966);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IIU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      aco localaco = (aco)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143966);
        return -1;
      case 1: 
        localaco.yth = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143966);
        return 0;
      case 7: 
        localaco.muv = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 2: 
        localaco.YMr = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143966);
        return 0;
      case 3: 
        localaco.ZkT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143966);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dfk localdfk = new dfk();
          if ((localObject != null) && (localObject.length > 0)) {
            localdfk.parseFrom((byte[])localObject);
          }
          localaco.IIU.add(localdfk);
          paramInt += 1;
        }
        AppMethodBeat.o(143966);
        return 0;
      case 5: 
        localaco.mut = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 6: 
        localaco.muu = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 8: 
        localaco.muw = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 9: 
        localaco.mux = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(143966);
        return 0;
      }
      localaco.vhO = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(143966);
      return 0;
    }
    AppMethodBeat.o(143966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aco
 * JD-Core Version:    0.7.0.1
 */