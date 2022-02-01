package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fnb
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> abNh;
  public int abNi;
  public LinkedList<duv> abmF;
  public String abmG;
  public String appid;
  public int version;
  public String wording;
  
  public fnb()
  {
    AppMethodBeat.i(176151);
    this.abNh = new LinkedList();
    this.abmF = new LinkedList();
    AppMethodBeat.o(176151);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176152);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.abNh);
      paramVarArgs.e(2, 8, this.abmF);
      if (this.wording != null) {
        paramVarArgs.g(3, this.wording);
      }
      paramVarArgs.bS(4, this.abNi);
      if (this.abmG != null) {
        paramVarArgs.g(5, this.abmG);
      }
      if (this.appid != null) {
        paramVarArgs.g(6, this.appid);
      }
      paramVarArgs.bS(7, this.version);
      AppMethodBeat.o(176152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 1, this.abNh) + 0 + i.a.a.a.c(2, 8, this.abmF);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wording);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.abNi);
      paramInt = i;
      if (this.abmG != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abmG);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.appid);
      }
      paramInt = i.a.a.b.b.a.cJ(7, this.version);
      AppMethodBeat.o(176152);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abNh.clear();
      this.abmF.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(176152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fnb localfnb = (fnb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176152);
        return -1;
      case 1: 
        localfnb.abNh.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(176152);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          duv localduv = new duv();
          if ((localObject != null) && (localObject.length > 0)) {
            localduv.parseFrom((byte[])localObject);
          }
          localfnb.abmF.add(localduv);
          paramInt += 1;
        }
        AppMethodBeat.o(176152);
        return 0;
      case 3: 
        localfnb.wording = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 4: 
        localfnb.abNi = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(176152);
        return 0;
      case 5: 
        localfnb.abmG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 6: 
        localfnb.appid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(176152);
        return 0;
      }
      localfnb.version = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(176152);
      return 0;
    }
    AppMethodBeat.o(176152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnb
 * JD-Core Version:    0.7.0.1
 */