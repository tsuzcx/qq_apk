package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbm
  extends com.tencent.mm.bx.a
{
  public LinkedList<bco> ZMd;
  public int ZMe;
  public long object_id;
  public String title;
  
  public bbm()
  {
    AppMethodBeat.i(259610);
    this.ZMd = new LinkedList();
    AppMethodBeat.o(259610);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259618);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.object_id);
      paramVarArgs.e(2, 8, this.ZMd);
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      paramVarArgs.bS(4, this.ZMe);
      AppMethodBeat.o(259618);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.object_id) + 0 + i.a.a.a.c(2, 8, this.ZMd);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.title);
      }
      i = i.a.a.b.b.a.cJ(4, this.ZMe);
      AppMethodBeat.o(259618);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZMd.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259618);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bbm localbbm = (bbm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259618);
        return -1;
      case 1: 
        localbbm.object_id = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259618);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bco localbco = new bco();
          if ((localObject != null) && (localObject.length > 0)) {
            localbco.parseFrom((byte[])localObject);
          }
          localbbm.ZMd.add(localbco);
          paramInt += 1;
        }
        AppMethodBeat.o(259618);
        return 0;
      case 3: 
        localbbm.title = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259618);
        return 0;
      }
      localbbm.ZMe = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(259618);
      return 0;
    }
    AppMethodBeat.o(259618);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbm
 * JD-Core Version:    0.7.0.1
 */