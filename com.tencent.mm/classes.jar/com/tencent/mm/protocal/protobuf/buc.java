package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buc
  extends com.tencent.mm.bx.a
{
  public bud DRx;
  public String DRy;
  public int zOa;
  public String zOc;
  public String zOd;
  public String zOe;
  public String zOf;
  public String zOg;
  public String zOh;
  public int zPQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72526);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.zPQ);
      if (this.DRx != null)
      {
        paramVarArgs.kX(2, this.DRx.computeSize());
        this.DRx.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.zOa);
      if (this.zOc != null) {
        paramVarArgs.d(4, this.zOc);
      }
      if (this.zOd != null) {
        paramVarArgs.d(5, this.zOd);
      }
      if (this.zOe != null) {
        paramVarArgs.d(6, this.zOe);
      }
      if (this.zOf != null) {
        paramVarArgs.d(7, this.zOf);
      }
      if (this.zOg != null) {
        paramVarArgs.d(8, this.zOg);
      }
      if (this.zOh != null) {
        paramVarArgs.d(9, this.zOh);
      }
      if (this.DRy != null) {
        paramVarArgs.d(10, this.DRy);
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.zPQ) + 0;
      paramInt = i;
      if (this.DRx != null) {
        paramInt = i + f.a.a.a.kW(2, this.DRx.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.zOa);
      paramInt = i;
      if (this.zOc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.zOc);
      }
      i = paramInt;
      if (this.zOd != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.zOd);
      }
      paramInt = i;
      if (this.zOe != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.zOe);
      }
      i = paramInt;
      if (this.zOf != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.zOf);
      }
      paramInt = i;
      if (this.zOg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.zOg);
      }
      i = paramInt;
      if (this.zOh != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.zOh);
      }
      paramInt = i;
      if (this.DRy != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DRy);
      }
      AppMethodBeat.o(72526);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      buc localbuc = (buc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72526);
        return -1;
      case 1: 
        localbuc.zPQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(72526);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bud();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bud)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbuc.DRx = ((bud)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72526);
        return 0;
      case 3: 
        localbuc.zOa = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(72526);
        return 0;
      case 4: 
        localbuc.zOc = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 5: 
        localbuc.zOd = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 6: 
        localbuc.zOe = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 7: 
        localbuc.zOf = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 8: 
        localbuc.zOg = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 9: 
        localbuc.zOh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72526);
        return 0;
      }
      localbuc.DRy = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(72526);
      return 0;
    }
    AppMethodBeat.o(72526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buc
 * JD-Core Version:    0.7.0.1
 */