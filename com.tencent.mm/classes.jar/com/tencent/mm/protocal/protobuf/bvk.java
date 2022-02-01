package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvk
  extends com.tencent.mm.bw.a
{
  public long FKy;
  public boolean FTM;
  public int FZN;
  public int GTv;
  public int GTx;
  public boolean Grn;
  public String Gud;
  public int Hie;
  public String Hif;
  public LinkedList<String> Hig;
  public boolean Hih;
  public String Hii;
  public String Hij;
  public String Hik;
  public String Hil;
  public int Him;
  public vx Hin;
  public int oEs;
  public int status;
  
  public bvk()
  {
    AppMethodBeat.i(215580);
    this.Hig = new LinkedList();
    AppMethodBeat.o(215580);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215581);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.FKy);
      if (this.Gud != null) {
        paramVarArgs.d(2, this.Gud);
      }
      paramVarArgs.aS(3, this.FZN);
      paramVarArgs.aS(4, this.oEs);
      paramVarArgs.aS(5, this.status);
      paramVarArgs.aS(6, this.GTv);
      paramVarArgs.aS(7, this.Hie);
      paramVarArgs.aS(8, this.GTx);
      if (this.Hif != null) {
        paramVarArgs.d(9, this.Hif);
      }
      paramVarArgs.e(10, 1, this.Hig);
      paramVarArgs.bC(11, this.FTM);
      paramVarArgs.bC(12, this.Grn);
      paramVarArgs.bC(13, this.Hih);
      if (this.Hii != null) {
        paramVarArgs.d(14, this.Hii);
      }
      if (this.Hij != null) {
        paramVarArgs.d(15, this.Hij);
      }
      if (this.Hik != null) {
        paramVarArgs.d(16, this.Hik);
      }
      if (this.Hil != null) {
        paramVarArgs.d(17, this.Hil);
      }
      paramVarArgs.aS(18, this.Him);
      if (this.Hin != null)
      {
        paramVarArgs.lJ(19, this.Hin.computeSize());
        this.Hin.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(215581);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FKy) + 0;
      paramInt = i;
      if (this.Gud != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gud);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FZN) + f.a.a.b.b.a.bz(4, this.oEs) + f.a.a.b.b.a.bz(5, this.status) + f.a.a.b.b.a.bz(6, this.GTv) + f.a.a.b.b.a.bz(7, this.Hie) + f.a.a.b.b.a.bz(8, this.GTx);
      paramInt = i;
      if (this.Hif != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hif);
      }
      i = paramInt + f.a.a.a.c(10, 1, this.Hig) + f.a.a.b.b.a.amF(11) + f.a.a.b.b.a.amF(12) + f.a.a.b.b.a.amF(13);
      paramInt = i;
      if (this.Hii != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Hii);
      }
      i = paramInt;
      if (this.Hij != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Hij);
      }
      paramInt = i;
      if (this.Hik != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Hik);
      }
      i = paramInt;
      if (this.Hil != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.Hil);
      }
      i += f.a.a.b.b.a.bz(18, this.Him);
      paramInt = i;
      if (this.Hin != null) {
        paramInt = i + f.a.a.a.lI(19, this.Hin.computeSize());
      }
      AppMethodBeat.o(215581);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hig.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(215581);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bvk localbvk = (bvk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(215581);
        return -1;
      case 1: 
        localbvk.FKy = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(215581);
        return 0;
      case 2: 
        localbvk.Gud = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(215581);
        return 0;
      case 3: 
        localbvk.FZN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(215581);
        return 0;
      case 4: 
        localbvk.oEs = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(215581);
        return 0;
      case 5: 
        localbvk.status = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(215581);
        return 0;
      case 6: 
        localbvk.GTv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(215581);
        return 0;
      case 7: 
        localbvk.Hie = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(215581);
        return 0;
      case 8: 
        localbvk.GTx = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(215581);
        return 0;
      case 9: 
        localbvk.Hif = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(215581);
        return 0;
      case 10: 
        localbvk.Hig.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(215581);
        return 0;
      case 11: 
        localbvk.FTM = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(215581);
        return 0;
      case 12: 
        localbvk.Grn = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(215581);
        return 0;
      case 13: 
        localbvk.Hih = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(215581);
        return 0;
      case 14: 
        localbvk.Hii = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(215581);
        return 0;
      case 15: 
        localbvk.Hij = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(215581);
        return 0;
      case 16: 
        localbvk.Hik = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(215581);
        return 0;
      case 17: 
        localbvk.Hil = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(215581);
        return 0;
      case 18: 
        localbvk.Him = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(215581);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new vx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((vx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbvk.Hin = ((vx)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(215581);
      return 0;
    }
    AppMethodBeat.o(215581);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvk
 * JD-Core Version:    0.7.0.1
 */