package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dor
  extends com.tencent.mm.cd.a
{
  public int SnQ;
  public LinkedList<dda> TVR;
  public String TVS;
  public boolean ThV;
  public String jump_url;
  public String wording;
  
  public dor()
  {
    AppMethodBeat.i(176148);
    this.TVR = new LinkedList();
    AppMethodBeat.o(176148);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176149);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.TVR);
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      if (this.TVS != null) {
        paramVarArgs.f(3, this.TVS);
      }
      if (this.jump_url != null) {
        paramVarArgs.f(4, this.jump_url);
      }
      paramVarArgs.co(5, this.ThV);
      paramVarArgs.aY(6, this.SnQ);
      AppMethodBeat.o(176149);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.TVR) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt;
      if (this.TVS != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TVS);
      }
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jump_url);
      }
      i = g.a.a.b.b.a.gL(5);
      int j = g.a.a.b.b.a.bM(6, this.SnQ);
      AppMethodBeat.o(176149);
      return paramInt + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TVR.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(176149);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dor localdor = (dor)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176149);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dda localdda = new dda();
          if ((localObject != null) && (localObject.length > 0)) {
            localdda.parseFrom((byte[])localObject);
          }
          localdor.TVR.add(localdda);
          paramInt += 1;
        }
        AppMethodBeat.o(176149);
        return 0;
      case 2: 
        localdor.wording = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 3: 
        localdor.TVS = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 4: 
        localdor.jump_url = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 5: 
        localdor.ThV = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(176149);
        return 0;
      }
      localdor.SnQ = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(176149);
      return 0;
    }
    AppMethodBeat.o(176149);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dor
 * JD-Core Version:    0.7.0.1
 */