package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csv
  extends com.tencent.mm.bw.a
{
  public String HDX;
  public double HDY;
  public LinkedList<tz> HDZ;
  public String HEa;
  public LinkedList<cwu> HEb;
  public long cbe;
  public String dwb;
  public String nickname;
  public String username;
  public String xcF;
  
  public csv()
  {
    AppMethodBeat.i(50103);
    this.HDZ = new LinkedList();
    this.HEb = new LinkedList();
    AppMethodBeat.o(50103);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50104);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.xcF != null) {
        paramVarArgs.d(4, this.xcF);
      }
      paramVarArgs.aZ(5, this.cbe);
      if (this.HDX != null) {
        paramVarArgs.d(6, this.HDX);
      }
      paramVarArgs.e(7, this.HDY);
      paramVarArgs.e(16, 8, this.HDZ);
      if (this.HEa != null) {
        paramVarArgs.d(17, this.HEa);
      }
      paramVarArgs.e(19, 8, this.HEb);
      AppMethodBeat.o(50104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label929;
      }
    }
    label929:
    for (int i = f.a.a.b.b.a.e(1, this.dwb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = i;
      if (this.xcF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xcF);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.cbe);
      paramInt = i;
      if (this.HDX != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HDX);
      }
      i = paramInt + f.a.a.b.b.a.amD(7) + f.a.a.a.c(16, 8, this.HDZ);
      paramInt = i;
      if (this.HEa != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.HEa);
      }
      i = f.a.a.a.c(19, 8, this.HEb);
      AppMethodBeat.o(50104);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HDZ.clear();
        this.HEb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csv localcsv = (csv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 18: 
        default: 
          AppMethodBeat.o(50104);
          return -1;
        case 1: 
          localcsv.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 2: 
          localcsv.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 3: 
          localcsv.nickname = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 4: 
          localcsv.xcF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 5: 
          localcsv.cbe = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(50104);
          return 0;
        case 6: 
          localcsv.HDX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 7: 
          localcsv.HDY = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(50104);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsv.HDZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50104);
          return 0;
        case 17: 
          localcsv.HEa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(50104);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcsv.HEb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      AppMethodBeat.o(50104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csv
 * JD-Core Version:    0.7.0.1
 */