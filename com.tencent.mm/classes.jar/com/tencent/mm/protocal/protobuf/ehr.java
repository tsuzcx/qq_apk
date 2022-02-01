package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehr
  extends com.tencent.mm.bw.a
{
  public LinkedList<cty> MJY;
  public String MJZ;
  public LinkedList<String> Nhh;
  public int Nhi;
  public String dNI;
  public String dQx;
  public int version;
  
  public ehr()
  {
    AppMethodBeat.i(176151);
    this.Nhh = new LinkedList();
    this.MJY = new LinkedList();
    AppMethodBeat.o(176151);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176152);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.Nhh);
      paramVarArgs.e(2, 8, this.MJY);
      if (this.dQx != null) {
        paramVarArgs.e(3, this.dQx);
      }
      paramVarArgs.aM(4, this.Nhi);
      if (this.MJZ != null) {
        paramVarArgs.e(5, this.MJZ);
      }
      if (this.dNI != null) {
        paramVarArgs.e(6, this.dNI);
      }
      paramVarArgs.aM(7, this.version);
      AppMethodBeat.o(176152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 1, this.Nhh) + 0 + g.a.a.a.c(2, 8, this.MJY);
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dQx);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Nhi);
      paramInt = i;
      if (this.MJZ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MJZ);
      }
      i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.dNI);
      }
      paramInt = g.a.a.b.b.a.bu(7, this.version);
      AppMethodBeat.o(176152);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Nhh.clear();
      this.MJY.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(176152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ehr localehr = (ehr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176152);
        return -1;
      case 1: 
        localehr.Nhh.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(176152);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cty();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cty)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localehr.MJY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176152);
        return 0;
      case 3: 
        localehr.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 4: 
        localehr.Nhi = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(176152);
        return 0;
      case 5: 
        localehr.MJZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 6: 
        localehr.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(176152);
        return 0;
      }
      localehr.version = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(176152);
      return 0;
    }
    AppMethodBeat.o(176152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehr
 * JD-Core Version:    0.7.0.1
 */