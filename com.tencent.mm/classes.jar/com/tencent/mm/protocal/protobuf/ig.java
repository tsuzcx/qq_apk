package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ig
  extends com.tencent.mm.bx.a
{
  public LinkedList<adn> CDO;
  public String CDP;
  public String CDQ;
  public String dca;
  public String szi;
  public String vur;
  public int vus;
  public int vut;
  public String vuu;
  public String vuv;
  public String vuw;
  public long vuz;
  
  public ig()
  {
    AppMethodBeat.i(72420);
    this.CDO = new LinkedList();
    AppMethodBeat.o(72420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dca != null) {
        paramVarArgs.d(1, this.dca);
      }
      if (this.szi != null) {
        paramVarArgs.d(2, this.szi);
      }
      if (this.vur != null) {
        paramVarArgs.d(3, this.vur);
      }
      paramVarArgs.aR(4, this.vus);
      paramVarArgs.aR(5, this.vut);
      paramVarArgs.e(6, 8, this.CDO);
      if (this.vuu != null) {
        paramVarArgs.d(7, this.vuu);
      }
      if (this.vuv != null) {
        paramVarArgs.d(8, this.vuv);
      }
      if (this.vuw != null) {
        paramVarArgs.d(9, this.vuw);
      }
      if (this.CDP != null) {
        paramVarArgs.d(10, this.CDP);
      }
      if (this.CDQ != null) {
        paramVarArgs.d(11, this.CDQ);
      }
      paramVarArgs.aG(12, this.vuz);
      AppMethodBeat.o(72421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dca == null) {
        break label918;
      }
    }
    label918:
    for (int i = f.a.a.b.b.a.e(1, this.dca) + 0;; i = 0)
    {
      paramInt = i;
      if (this.szi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.szi);
      }
      i = paramInt;
      if (this.vur != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vur);
      }
      i = i + f.a.a.b.b.a.bA(4, this.vus) + f.a.a.b.b.a.bA(5, this.vut) + f.a.a.a.c(6, 8, this.CDO);
      paramInt = i;
      if (this.vuu != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vuu);
      }
      i = paramInt;
      if (this.vuv != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.vuv);
      }
      paramInt = i;
      if (this.vuw != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.vuw);
      }
      i = paramInt;
      if (this.CDP != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CDP);
      }
      paramInt = i;
      if (this.CDQ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CDQ);
      }
      i = f.a.a.b.b.a.q(12, this.vuz);
      AppMethodBeat.o(72421);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CDO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ig localig = (ig)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72421);
          return -1;
        case 1: 
          localig.dca = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 2: 
          localig.szi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 3: 
          localig.vur = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 4: 
          localig.vus = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72421);
          return 0;
        case 5: 
          localig.vut = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72421);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((adn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localig.CDO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72421);
          return 0;
        case 7: 
          localig.vuu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 8: 
          localig.vuv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 9: 
          localig.vuw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 10: 
          localig.CDP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 11: 
          localig.CDQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72421);
          return 0;
        }
        localig.vuz = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(72421);
        return 0;
      }
      AppMethodBeat.o(72421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ig
 * JD-Core Version:    0.7.0.1
 */