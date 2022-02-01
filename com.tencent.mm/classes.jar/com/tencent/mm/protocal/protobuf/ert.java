package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ert
  extends com.tencent.mm.cd.a
{
  public LinkedList<dda> TVR;
  public String TVS;
  public LinkedList<String> UtN;
  public int UtO;
  public String appid;
  public int version;
  public String wording;
  
  public ert()
  {
    AppMethodBeat.i(176151);
    this.UtN = new LinkedList();
    this.TVR = new LinkedList();
    AppMethodBeat.o(176151);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176152);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.UtN);
      paramVarArgs.e(2, 8, this.TVR);
      if (this.wording != null) {
        paramVarArgs.f(3, this.wording);
      }
      paramVarArgs.aY(4, this.UtO);
      if (this.TVS != null) {
        paramVarArgs.f(5, this.TVS);
      }
      if (this.appid != null) {
        paramVarArgs.f(6, this.appid);
      }
      paramVarArgs.aY(7, this.version);
      AppMethodBeat.o(176152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 1, this.UtN) + 0 + g.a.a.a.c(2, 8, this.TVR);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.wording);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.UtO);
      paramInt = i;
      if (this.TVS != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TVS);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.appid);
      }
      paramInt = g.a.a.b.b.a.bM(7, this.version);
      AppMethodBeat.o(176152);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UtN.clear();
      this.TVR.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(176152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ert localert = (ert)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176152);
        return -1;
      case 1: 
        localert.UtN.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(176152);
        return 0;
      case 2: 
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
          localert.TVR.add(localdda);
          paramInt += 1;
        }
        AppMethodBeat.o(176152);
        return 0;
      case 3: 
        localert.wording = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 4: 
        localert.UtO = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(176152);
        return 0;
      case 5: 
        localert.TVS = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 6: 
        localert.appid = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(176152);
        return 0;
      }
      localert.version = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(176152);
      return 0;
    }
    AppMethodBeat.o(176152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ert
 * JD-Core Version:    0.7.0.1
 */