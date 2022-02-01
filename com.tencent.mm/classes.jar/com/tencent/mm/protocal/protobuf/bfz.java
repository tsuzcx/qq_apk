package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfz
  extends com.tencent.mm.bx.a
{
  public LinkedList<acl> ZNH;
  public String ZPK;
  public int lTH;
  
  public bfz()
  {
    AppMethodBeat.i(258317);
    this.ZNH = new LinkedList();
    AppMethodBeat.o(258317);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258319);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZNH);
      if (this.ZPK != null) {
        paramVarArgs.g(2, this.ZPK);
      }
      paramVarArgs.bS(3, this.lTH);
      AppMethodBeat.o(258319);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ZNH) + 0;
      paramInt = i;
      if (this.ZPK != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZPK);
      }
      i = i.a.a.b.b.a.cJ(3, this.lTH);
      AppMethodBeat.o(258319);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZNH.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258319);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bfz localbfz = (bfz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258319);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          acl localacl = new acl();
          if ((localObject != null) && (localObject.length > 0)) {
            localacl.parseFrom((byte[])localObject);
          }
          localbfz.ZNH.add(localacl);
          paramInt += 1;
        }
        AppMethodBeat.o(258319);
        return 0;
      case 2: 
        localbfz.ZPK = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258319);
        return 0;
      }
      localbfz.lTH = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(258319);
      return 0;
    }
    AppMethodBeat.o(258319);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfz
 * JD-Core Version:    0.7.0.1
 */