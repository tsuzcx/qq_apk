package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pw
  extends com.tencent.mm.cd.a
{
  public String OOM;
  public LinkedList<pw> RYg;
  public int id;
  public String key;
  public int lEJ;
  public String name;
  public int type;
  public String value;
  
  public pw()
  {
    AppMethodBeat.i(124457);
    this.RYg = new LinkedList();
    AppMethodBeat.o(124457);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124458);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.id);
      paramVarArgs.aY(2, this.type);
      if (this.name != null) {
        paramVarArgs.f(3, this.name);
      }
      if (this.key != null) {
        paramVarArgs.f(4, this.key);
      }
      if (this.value != null) {
        paramVarArgs.f(5, this.value);
      }
      paramVarArgs.e(6, 8, this.RYg);
      paramVarArgs.aY(7, this.lEJ);
      if (this.OOM != null) {
        paramVarArgs.f(8, this.OOM);
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.id) + 0 + g.a.a.b.b.a.bM(2, this.type);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.name);
      }
      i = paramInt;
      if (this.key != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.key);
      }
      paramInt = i;
      if (this.value != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.value);
      }
      i = paramInt + g.a.a.a.c(6, 8, this.RYg) + g.a.a.b.b.a.bM(7, this.lEJ);
      paramInt = i;
      if (this.OOM != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.OOM);
      }
      AppMethodBeat.o(124458);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RYg.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      pw localpw1 = (pw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124458);
        return -1;
      case 1: 
        localpw1.id = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(124458);
        return 0;
      case 2: 
        localpw1.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(124458);
        return 0;
      case 3: 
        localpw1.name = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 4: 
        localpw1.key = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 5: 
        localpw1.value = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          pw localpw2 = new pw();
          if ((localObject != null) && (localObject.length > 0)) {
            localpw2.parseFrom((byte[])localObject);
          }
          localpw1.RYg.add(localpw2);
          paramInt += 1;
        }
        AppMethodBeat.o(124458);
        return 0;
      case 7: 
        localpw1.lEJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(124458);
        return 0;
      }
      localpw1.OOM = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(124458);
      return 0;
    }
    AppMethodBeat.o(124458);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pw
 * JD-Core Version:    0.7.0.1
 */