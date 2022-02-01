package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class eu
  extends com.tencent.mm.bx.a
{
  public int CyW;
  public String CyX;
  public int CyY;
  public boolean CyZ;
  public int Cza;
  public int Czb;
  public int Czc;
  public int Czd;
  public boolean Cze;
  public LinkedList<dcg> Czf;
  public String Url;
  public int gKq;
  public String gKr;
  public int uKX;
  
  public eu()
  {
    AppMethodBeat.i(6388);
    this.CyW = 600;
    this.gKq = -1;
    this.Cze = false;
    this.Czf = new LinkedList();
    AppMethodBeat.o(6388);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6389);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      if (this.gKr != null) {
        paramVarArgs.d(2, this.gKr);
      }
      paramVarArgs.aR(3, this.CyW);
      if (this.CyX != null) {
        paramVarArgs.d(4, this.CyX);
      }
      paramVarArgs.aR(5, this.CyY);
      paramVarArgs.bg(6, this.CyZ);
      paramVarArgs.aR(7, this.Cza);
      paramVarArgs.aR(8, this.Czb);
      paramVarArgs.aR(9, this.uKX);
      paramVarArgs.aR(10, this.Czc);
      paramVarArgs.aR(11, this.Czd);
      paramVarArgs.aR(12, this.gKq);
      paramVarArgs.bg(13, this.Cze);
      paramVarArgs.e(14, 8, this.Czf);
      AppMethodBeat.o(6389);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.b.b.a.e(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gKr);
      }
      i += f.a.a.b.b.a.bA(3, this.CyW);
      paramInt = i;
      if (this.CyX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CyX);
      }
      i = f.a.a.b.b.a.bA(5, this.CyY);
      int j = f.a.a.b.b.a.fY(6);
      int k = f.a.a.b.b.a.bA(7, this.Cza);
      int m = f.a.a.b.b.a.bA(8, this.Czb);
      int n = f.a.a.b.b.a.bA(9, this.uKX);
      int i1 = f.a.a.b.b.a.bA(10, this.Czc);
      int i2 = f.a.a.b.b.a.bA(11, this.Czd);
      int i3 = f.a.a.b.b.a.bA(12, this.gKq);
      int i4 = f.a.a.b.b.a.fY(13);
      int i5 = f.a.a.a.c(14, 8, this.Czf);
      AppMethodBeat.o(6389);
      return paramInt + i + (j + 1) + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Czf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eu localeu = (eu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6389);
          return -1;
        case 1: 
          localeu.Url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 2: 
          localeu.gKr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 3: 
          localeu.CyW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6389);
          return 0;
        case 4: 
          localeu.CyX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 5: 
          localeu.CyY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6389);
          return 0;
        case 6: 
          localeu.CyZ = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(6389);
          return 0;
        case 7: 
          localeu.Cza = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6389);
          return 0;
        case 8: 
          localeu.Czb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6389);
          return 0;
        case 9: 
          localeu.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6389);
          return 0;
        case 10: 
          localeu.Czc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6389);
          return 0;
        case 11: 
          localeu.Czd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6389);
          return 0;
        case 12: 
          localeu.gKq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(6389);
          return 0;
        case 13: 
          localeu.Cze = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(6389);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dcg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeu.Czf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      AppMethodBeat.o(6389);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eu
 * JD-Core Version:    0.7.0.1
 */