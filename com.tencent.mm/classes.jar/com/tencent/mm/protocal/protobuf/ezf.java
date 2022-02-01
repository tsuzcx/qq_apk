package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezf
  extends com.tencent.mm.bx.a
{
  public String aajW;
  public long aajX;
  public LinkedList<ezb> abAl;
  public int index;
  public boolean lAr;
  public int type;
  public String zIC;
  
  public ezf()
  {
    AppMethodBeat.i(169384);
    this.abAl = new LinkedList();
    this.lAr = false;
    this.type = 0;
    this.index = -1;
    AppMethodBeat.o(169384);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169385);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.zIC != null) {
        paramVarArgs.g(1, this.zIC);
      }
      paramVarArgs.bv(2, this.aajX);
      paramVarArgs.e(3, 8, this.abAl);
      if (this.aajW != null) {
        paramVarArgs.g(4, this.aajW);
      }
      paramVarArgs.di(5, this.lAr);
      paramVarArgs.bS(6, this.type);
      paramVarArgs.bS(7, this.index);
      AppMethodBeat.o(169385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zIC == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.b.b.a.h(1, this.zIC) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.aajX) + i.a.a.a.c(3, 8, this.abAl);
      paramInt = i;
      if (this.aajW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aajW);
      }
      i = i.a.a.b.b.a.ko(5);
      int j = i.a.a.b.b.a.cJ(6, this.type);
      int k = i.a.a.b.b.a.cJ(7, this.index);
      AppMethodBeat.o(169385);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abAl.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169385);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ezf localezf = (ezf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169385);
          return -1;
        case 1: 
          localezf.zIC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 2: 
          localezf.aajX = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(169385);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ezb localezb = new ezb();
            if ((localObject != null) && (localObject.length > 0)) {
              localezb.parseFrom((byte[])localObject);
            }
            localezf.abAl.add(localezb);
            paramInt += 1;
          }
          AppMethodBeat.o(169385);
          return 0;
        case 4: 
          localezf.aajW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 5: 
          localezf.lAr = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(169385);
          return 0;
        case 6: 
          localezf.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169385);
          return 0;
        }
        localezf.index = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169385);
        return 0;
      }
      AppMethodBeat.o(169385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezf
 * JD-Core Version:    0.7.0.1
 */