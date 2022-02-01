package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tz
  extends com.tencent.mm.cd.a
{
  public String RDy;
  public LinkedList<aeg> Sdu;
  public int Sdv;
  public String Sdw;
  public String name;
  
  public tz()
  {
    AppMethodBeat.i(32155);
    this.Sdu = new LinkedList();
    AppMethodBeat.o(32155);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32156);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Sdu);
      if (this.RDy != null) {
        paramVarArgs.f(2, this.RDy);
      }
      paramVarArgs.aY(3, this.Sdv);
      if (this.Sdw != null) {
        paramVarArgs.f(4, this.Sdw);
      }
      if (this.name != null) {
        paramVarArgs.f(5, this.name);
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Sdu) + 0;
      paramInt = i;
      if (this.RDy != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RDy);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.Sdv);
      paramInt = i;
      if (this.Sdw != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sdw);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.name);
      }
      AppMethodBeat.o(32156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Sdu.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      tz localtz = (tz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32156);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aeg localaeg = new aeg();
          if ((localObject != null) && (localObject.length > 0)) {
            localaeg.parseFrom((byte[])localObject);
          }
          localtz.Sdu.add(localaeg);
          paramInt += 1;
        }
        AppMethodBeat.o(32156);
        return 0;
      case 2: 
        localtz.RDy = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32156);
        return 0;
      case 3: 
        localtz.Sdv = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32156);
        return 0;
      case 4: 
        localtz.Sdw = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32156);
        return 0;
      }
      localtz.name = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(32156);
      return 0;
    }
    AppMethodBeat.o(32156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tz
 * JD-Core Version:    0.7.0.1
 */