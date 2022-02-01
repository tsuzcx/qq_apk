package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bvv
  extends com.tencent.mm.bx.a
{
  public int aadH;
  public LinkedList<FinderContact> aadI;
  public int sve;
  public int type;
  
  public bvv()
  {
    AppMethodBeat.i(258790);
    this.aadI = new LinkedList();
    AppMethodBeat.o(258790);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258795);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.bS(2, this.sve);
      paramVarArgs.bS(3, this.aadH);
      paramVarArgs.e(4, 8, this.aadI);
      AppMethodBeat.o(258795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.type);
      i = i.a.a.b.b.a.cJ(2, this.sve);
      int j = i.a.a.b.b.a.cJ(3, this.aadH);
      int k = i.a.a.a.c(4, 8, this.aadI);
      AppMethodBeat.o(258795);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aadI.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258795);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bvv localbvv = (bvv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258795);
        return -1;
      case 1: 
        localbvv.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258795);
        return 0;
      case 2: 
        localbvv.sve = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258795);
        return 0;
      case 3: 
        localbvv.aadH = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258795);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        FinderContact localFinderContact = new FinderContact();
        if ((localObject != null) && (localObject.length > 0)) {
          localFinderContact.parseFrom((byte[])localObject);
        }
        localbvv.aadI.add(localFinderContact);
        paramInt += 1;
      }
      AppMethodBeat.o(258795);
      return 0;
    }
    AppMethodBeat.o(258795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvv
 * JD-Core Version:    0.7.0.1
 */