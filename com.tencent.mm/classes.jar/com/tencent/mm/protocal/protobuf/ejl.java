package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejl
  extends com.tencent.mm.bx.a
{
  public int abnY;
  public boolean abnZ;
  public String aboa;
  public int abob;
  public int aboc;
  public LinkedList<ejk> abod;
  public String iaI;
  
  public ejl()
  {
    AppMethodBeat.i(114057);
    this.abod = new LinkedList();
    AppMethodBeat.o(114057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114058);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.iaI != null) {
        paramVarArgs.g(1, this.iaI);
      }
      paramVarArgs.bS(2, this.abnY);
      paramVarArgs.di(3, this.abnZ);
      if (this.aboa != null) {
        paramVarArgs.g(4, this.aboa);
      }
      paramVarArgs.bS(5, this.abob);
      paramVarArgs.bS(6, this.aboc);
      paramVarArgs.e(7, 8, this.abod);
      AppMethodBeat.o(114058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iaI == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.b.b.a.h(1, this.iaI) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abnY) + (i.a.a.b.b.a.ko(3) + 1);
      paramInt = i;
      if (this.aboa != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aboa);
      }
      i = i.a.a.b.b.a.cJ(5, this.abob);
      int j = i.a.a.b.b.a.cJ(6, this.aboc);
      int k = i.a.a.a.c(7, 8, this.abod);
      AppMethodBeat.o(114058);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abod.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ejl localejl = (ejl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114058);
          return -1;
        case 1: 
          localejl.iaI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 2: 
          localejl.abnY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114058);
          return 0;
        case 3: 
          localejl.abnZ = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(114058);
          return 0;
        case 4: 
          localejl.aboa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 5: 
          localejl.abob = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114058);
          return 0;
        case 6: 
          localejl.aboc = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114058);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ejk localejk = new ejk();
          if ((localObject != null) && (localObject.length > 0)) {
            localejk.parseFrom((byte[])localObject);
          }
          localejl.abod.add(localejk);
          paramInt += 1;
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      AppMethodBeat.o(114058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejl
 * JD-Core Version:    0.7.0.1
 */