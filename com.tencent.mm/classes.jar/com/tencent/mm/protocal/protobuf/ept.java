package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ept
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> aaTg;
  public int abtI;
  public LinkedList<ept> abtJ;
  public LinkedList<String> abtK;
  public int abtL;
  public String defaultValue;
  public String key;
  public String name;
  public int type;
  
  public ept()
  {
    AppMethodBeat.i(259113);
    this.aaTg = new LinkedList();
    this.abtJ = new LinkedList();
    this.abtK = new LinkedList();
    AppMethodBeat.o(259113);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259117);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.g(1, this.key);
      }
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      paramVarArgs.bS(3, this.type);
      paramVarArgs.e(4, 1, this.aaTg);
      paramVarArgs.bS(5, this.abtI);
      paramVarArgs.e(6, 8, this.abtJ);
      paramVarArgs.e(7, 1, this.abtK);
      paramVarArgs.bS(8, this.abtL);
      if (this.defaultValue != null) {
        paramVarArgs.g(9, this.defaultValue);
      }
      AppMethodBeat.o(259117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label696;
      }
    }
    label696:
    for (paramInt = i.a.a.b.b.a.h(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.name);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.type) + i.a.a.a.c(4, 1, this.aaTg) + i.a.a.b.b.a.cJ(5, this.abtI) + i.a.a.a.c(6, 8, this.abtJ) + i.a.a.a.c(7, 1, this.abtK) + i.a.a.b.b.a.cJ(8, this.abtL);
      paramInt = i;
      if (this.defaultValue != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.defaultValue);
      }
      AppMethodBeat.o(259117);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaTg.clear();
        this.abtJ.clear();
        this.abtK.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259117);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ept localept1 = (ept)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259117);
          return -1;
        case 1: 
          localept1.key = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259117);
          return 0;
        case 2: 
          localept1.name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259117);
          return 0;
        case 3: 
          localept1.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259117);
          return 0;
        case 4: 
          localept1.aaTg.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(259117);
          return 0;
        case 5: 
          localept1.abtI = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259117);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ept localept2 = new ept();
            if ((localObject != null) && (localObject.length > 0)) {
              localept2.parseFrom((byte[])localObject);
            }
            localept1.abtJ.add(localept2);
            paramInt += 1;
          }
          AppMethodBeat.o(259117);
          return 0;
        case 7: 
          localept1.abtK.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(259117);
          return 0;
        case 8: 
          localept1.abtL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259117);
          return 0;
        }
        localept1.defaultValue = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259117);
        return 0;
      }
      AppMethodBeat.o(259117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ept
 * JD-Core Version:    0.7.0.1
 */