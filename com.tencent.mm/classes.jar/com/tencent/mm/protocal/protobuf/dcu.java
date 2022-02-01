package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcu
  extends com.tencent.mm.bx.a
{
  public int Euh;
  public int Eui;
  public String Euj;
  public dct Euk;
  public boolean ddw;
  public int gBm;
  public String id;
  public String jTI;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153001);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Euh);
      paramVarArgs.aR(2, this.gBm);
      paramVarArgs.aR(3, this.Eui);
      paramVarArgs.aR(4, this.type);
      if (this.id != null) {
        paramVarArgs.d(5, this.id);
      }
      if (this.jTI != null) {
        paramVarArgs.d(6, this.jTI);
      }
      if (this.Euj != null) {
        paramVarArgs.d(7, this.Euj);
      }
      if (this.Euk != null)
      {
        paramVarArgs.kX(8, this.Euk.computeSize());
        this.Euk.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(9, this.ddw);
      AppMethodBeat.o(153001);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Euh) + 0 + f.a.a.b.b.a.bA(2, this.gBm) + f.a.a.b.b.a.bA(3, this.Eui) + f.a.a.b.b.a.bA(4, this.type);
      paramInt = i;
      if (this.id != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.id);
      }
      i = paramInt;
      if (this.jTI != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.jTI);
      }
      paramInt = i;
      if (this.Euj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Euj);
      }
      i = paramInt;
      if (this.Euk != null) {
        i = paramInt + f.a.a.a.kW(8, this.Euk.computeSize());
      }
      paramInt = f.a.a.b.b.a.fY(9);
      AppMethodBeat.o(153001);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(153001);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dcu localdcu = (dcu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153001);
        return -1;
      case 1: 
        localdcu.Euh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153001);
        return 0;
      case 2: 
        localdcu.gBm = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153001);
        return 0;
      case 3: 
        localdcu.Eui = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153001);
        return 0;
      case 4: 
        localdcu.type = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153001);
        return 0;
      case 5: 
        localdcu.id = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 6: 
        localdcu.jTI = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 7: 
        localdcu.Euj = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dct();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dct)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcu.Euk = ((dct)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153001);
        return 0;
      }
      localdcu.ddw = ((f.a.a.a.a)localObject1).KhF.fHu();
      AppMethodBeat.o(153001);
      return 0;
    }
    AppMethodBeat.o(153001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcu
 * JD-Core Version:    0.7.0.1
 */