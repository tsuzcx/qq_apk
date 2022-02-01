package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rg
  extends com.tencent.mm.bx.a
{
  public String VEG;
  public LinkedList<rg> YWf;
  public int id;
  public String key;
  public String name;
  public int owp;
  public int type;
  public String value;
  
  public rg()
  {
    AppMethodBeat.i(124457);
    this.YWf = new LinkedList();
    AppMethodBeat.o(124457);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124458);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.id);
      paramVarArgs.bS(2, this.type);
      if (this.name != null) {
        paramVarArgs.g(3, this.name);
      }
      if (this.key != null) {
        paramVarArgs.g(4, this.key);
      }
      if (this.value != null) {
        paramVarArgs.g(5, this.value);
      }
      paramVarArgs.e(6, 8, this.YWf);
      paramVarArgs.bS(7, this.owp);
      if (this.VEG != null) {
        paramVarArgs.g(8, this.VEG);
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.id) + 0 + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.name);
      }
      i = paramInt;
      if (this.key != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.key);
      }
      paramInt = i;
      if (this.value != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.value);
      }
      i = paramInt + i.a.a.a.c(6, 8, this.YWf) + i.a.a.b.b.a.cJ(7, this.owp);
      paramInt = i;
      if (this.VEG != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.VEG);
      }
      AppMethodBeat.o(124458);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YWf.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      rg localrg1 = (rg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124458);
        return -1;
      case 1: 
        localrg1.id = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124458);
        return 0;
      case 2: 
        localrg1.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124458);
        return 0;
      case 3: 
        localrg1.name = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 4: 
        localrg1.key = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 5: 
        localrg1.value = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          rg localrg2 = new rg();
          if ((localObject != null) && (localObject.length > 0)) {
            localrg2.parseFrom((byte[])localObject);
          }
          localrg1.YWf.add(localrg2);
          paramInt += 1;
        }
        AppMethodBeat.o(124458);
        return 0;
      case 7: 
        localrg1.owp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124458);
        return 0;
      }
      localrg1.VEG = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(124458);
      return 0;
    }
    AppMethodBeat.o(124458);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rg
 * JD-Core Version:    0.7.0.1
 */