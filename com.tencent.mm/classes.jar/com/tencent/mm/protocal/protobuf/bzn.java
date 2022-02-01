package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzn
  extends com.tencent.mm.bx.a
{
  public chz DWr;
  public String desc;
  public String gGR;
  public String name;
  public String title;
  public int uaQ;
  public String zHs;
  public String zHt;
  public String zVl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      if (this.gGR != null) {
        paramVarArgs.d(4, this.gGR);
      }
      paramVarArgs.aR(5, this.uaQ);
      if (this.zVl != null) {
        paramVarArgs.d(6, this.zVl);
      }
      if (this.zHs != null) {
        paramVarArgs.d(7, this.zHs);
      }
      if (this.zHt != null) {
        paramVarArgs.d(8, this.zHt);
      }
      if (this.DWr != null)
      {
        paramVarArgs.kX(9, this.DWr.computeSize());
        this.DWr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.desc);
      }
      paramInt = i;
      if (this.gGR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gGR);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.uaQ);
      paramInt = i;
      if (this.zVl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.zVl);
      }
      i = paramInt;
      if (this.zHs != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.zHs);
      }
      paramInt = i;
      if (this.zHt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.zHt);
      }
      i = paramInt;
      if (this.DWr != null) {
        i = paramInt + f.a.a.a.kW(9, this.DWr.computeSize());
      }
      AppMethodBeat.o(72542);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzn localbzn = (bzn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72542);
          return -1;
        case 1: 
          localbzn.name = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 2: 
          localbzn.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 3: 
          localbzn.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 4: 
          localbzn.gGR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 5: 
          localbzn.uaQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72542);
          return 0;
        case 6: 
          localbzn.zVl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 7: 
          localbzn.zHs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 8: 
          localbzn.zHt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72542);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((chz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzn.DWr = ((chz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      AppMethodBeat.o(72542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzn
 * JD-Core Version:    0.7.0.1
 */