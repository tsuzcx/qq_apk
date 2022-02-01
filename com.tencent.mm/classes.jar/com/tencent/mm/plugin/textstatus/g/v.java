package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class v
  extends com.tencent.mm.bw.a
{
  public g GaU;
  public LinkedList<String> GaV;
  public boolean GaW;
  public String GaX;
  public int GaY;
  public int GaZ;
  public long Gba;
  public boolean Gbb;
  public String Usb;
  public String errMsg;
  public String thumbPath;
  
  public v()
  {
    AppMethodBeat.i(216012);
    this.GaV = new LinkedList();
    AppMethodBeat.o(216012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(216013);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GaU != null)
      {
        paramVarArgs.ni(1, this.GaU.computeSize());
        this.GaU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.GaV);
      paramVarArgs.cc(3, this.GaW);
      if (this.GaX != null) {
        paramVarArgs.e(4, this.GaX);
      }
      if (this.thumbPath != null) {
        paramVarArgs.e(5, this.thumbPath);
      }
      paramVarArgs.aM(6, this.GaY);
      paramVarArgs.aM(7, this.GaZ);
      paramVarArgs.bb(8, this.Gba);
      paramVarArgs.cc(9, this.Gbb);
      if (this.errMsg != null) {
        paramVarArgs.e(10, this.errMsg);
      }
      if (this.Usb != null) {
        paramVarArgs.e(11, this.Usb);
      }
      AppMethodBeat.o(216013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GaU == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = g.a.a.a.nh(1, this.GaU.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.GaV) + (g.a.a.b.b.a.fS(3) + 1);
      paramInt = i;
      if (this.GaX != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.GaX);
      }
      i = paramInt;
      if (this.thumbPath != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.thumbPath);
      }
      i = i + g.a.a.b.b.a.bu(6, this.GaY) + g.a.a.b.b.a.bu(7, this.GaZ) + g.a.a.b.b.a.r(8, this.Gba) + (g.a.a.b.b.a.fS(9) + 1);
      paramInt = i;
      if (this.errMsg != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.errMsg);
      }
      i = paramInt;
      if (this.Usb != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.Usb);
      }
      AppMethodBeat.o(216013);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GaV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(216013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(216013);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localv.GaU = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(216013);
          return 0;
        case 2: 
          localv.GaV.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(216013);
          return 0;
        case 3: 
          localv.GaW = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(216013);
          return 0;
        case 4: 
          localv.GaX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(216013);
          return 0;
        case 5: 
          localv.thumbPath = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(216013);
          return 0;
        case 6: 
          localv.GaY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(216013);
          return 0;
        case 7: 
          localv.GaZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(216013);
          return 0;
        case 8: 
          localv.Gba = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(216013);
          return 0;
        case 9: 
          localv.Gbb = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(216013);
          return 0;
        case 10: 
          localv.errMsg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(216013);
          return 0;
        }
        localv.Usb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(216013);
        return 0;
      }
      AppMethodBeat.o(216013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.v
 * JD-Core Version:    0.7.0.1
 */