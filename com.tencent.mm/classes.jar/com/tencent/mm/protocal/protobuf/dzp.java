package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzp
  extends com.tencent.mm.bx.a
{
  public LinkedList<dzp> VXB;
  public String abeK;
  public LinkedList<dzo> abeL;
  public int abeM;
  public int abeN;
  public int fZW;
  public String type;
  public String ycW;
  
  public dzp()
  {
    AppMethodBeat.i(117537);
    this.abeL = new LinkedList();
    this.VXB = new LinkedList();
    AppMethodBeat.o(117537);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117538);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abeK != null) {
        paramVarArgs.g(1, this.abeK);
      }
      if (this.ycW != null) {
        paramVarArgs.g(2, this.ycW);
      }
      paramVarArgs.e(3, 8, this.abeL);
      paramVarArgs.bS(4, this.fZW);
      if (this.type != null) {
        paramVarArgs.g(5, this.type);
      }
      paramVarArgs.e(6, 8, this.VXB);
      paramVarArgs.bS(7, this.abeM);
      paramVarArgs.bS(8, this.abeN);
      AppMethodBeat.o(117538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abeK == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = i.a.a.b.b.a.h(1, this.abeK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ycW != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ycW);
      }
      i = i + i.a.a.a.c(3, 8, this.abeL) + i.a.a.b.b.a.cJ(4, this.fZW);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.type);
      }
      i = i.a.a.a.c(6, 8, this.VXB);
      int j = i.a.a.b.b.a.cJ(7, this.abeM);
      int k = i.a.a.b.b.a.cJ(8, this.abeN);
      AppMethodBeat.o(117538);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abeL.clear();
        this.VXB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dzp localdzp = (dzp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117538);
          return -1;
        case 1: 
          localdzp.abeK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 2: 
          localdzp.ycW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzo)localObject2).parseFrom((byte[])localObject1);
            }
            localdzp.abeL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 4: 
          localdzp.fZW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117538);
          return 0;
        case 5: 
          localdzp.type = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzp)localObject2).parseFrom((byte[])localObject1);
            }
            localdzp.VXB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 7: 
          localdzp.abeM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117538);
          return 0;
        }
        localdzp.abeN = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117538);
        return 0;
      }
      AppMethodBeat.o(117538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzp
 * JD-Core Version:    0.7.0.1
 */