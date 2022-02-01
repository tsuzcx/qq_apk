package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fxj
  extends com.tencent.mm.bx.a
{
  public LinkedList<fxk> ZgM;
  public int abNi;
  public String abmG;
  public String appid;
  public int version;
  public String wording;
  
  public fxj()
  {
    AppMethodBeat.i(176154);
    this.ZgM = new LinkedList();
    AppMethodBeat.o(176154);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176155);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZgM);
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      paramVarArgs.bS(3, this.abNi);
      if (this.abmG != null) {
        paramVarArgs.g(4, this.abmG);
      }
      if (this.appid != null) {
        paramVarArgs.g(5, this.appid);
      }
      paramVarArgs.bS(6, this.version);
      AppMethodBeat.o(176155);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ZgM) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.abNi);
      paramInt = i;
      if (this.abmG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abmG);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.appid);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.version);
      AppMethodBeat.o(176155);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZgM.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(176155);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fxj localfxj = (fxj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176155);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fxk localfxk = new fxk();
          if ((localObject != null) && (localObject.length > 0)) {
            localfxk.parseFrom((byte[])localObject);
          }
          localfxj.ZgM.add(localfxk);
          paramInt += 1;
        }
        AppMethodBeat.o(176155);
        return 0;
      case 2: 
        localfxj.wording = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 3: 
        localfxj.abNi = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(176155);
        return 0;
      case 4: 
        localfxj.abmG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 5: 
        localfxj.appid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(176155);
        return 0;
      }
      localfxj.version = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(176155);
      return 0;
    }
    AppMethodBeat.o(176155);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxj
 * JD-Core Version:    0.7.0.1
 */