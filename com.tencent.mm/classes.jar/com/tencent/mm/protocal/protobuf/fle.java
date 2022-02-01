package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fle
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String SYn;
  public String Sas;
  public int Sat;
  public String TQa;
  public int Tkv;
  public cqh TwK;
  public LinkedList<aci> UIj;
  public int UJW;
  public String UJX;
  public String UJY;
  public LinkedList<String> UJZ;
  public int UKa;
  public bls UKb;
  public String Uab;
  public int UdE;
  public int Udh;
  public int Udl;
  public int Ute;
  public int rWu;
  
  public fle()
  {
    AppMethodBeat.i(117947);
    this.UJW = 2;
    this.UIj = new LinkedList();
    this.UJZ = new LinkedList();
    AppMethodBeat.o(117947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117948);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Sat);
      paramVarArgs.aY(2, this.Tkv);
      paramVarArgs.aY(3, this.Udh);
      if (this.SYn != null) {
        paramVarArgs.f(4, this.SYn);
      }
      if (this.TwK != null)
      {
        paramVarArgs.oE(5, this.TwK.computeSize());
        this.TwK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.CPw);
      if (this.Sas != null) {
        paramVarArgs.f(7, this.Sas);
      }
      paramVarArgs.aY(8, this.Udl);
      paramVarArgs.aY(9, this.UJW);
      paramVarArgs.e(10, 8, this.UIj);
      if (this.UJX != null) {
        paramVarArgs.f(11, this.UJX);
      }
      if (this.TQa != null) {
        paramVarArgs.f(12, this.TQa);
      }
      paramVarArgs.aY(13, this.Ute);
      if (this.UJY != null) {
        paramVarArgs.f(14, this.UJY);
      }
      if (this.Uab != null) {
        paramVarArgs.f(15, this.Uab);
      }
      paramVarArgs.e(16, 1, this.UJZ);
      paramVarArgs.aY(17, this.UdE);
      paramVarArgs.aY(18, this.rWu);
      paramVarArgs.aY(19, this.UKa);
      if (this.UKb != null)
      {
        paramVarArgs.oE(20, this.UKb.computeSize());
        this.UKb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Sat) + 0 + g.a.a.b.b.a.bM(2, this.Tkv) + g.a.a.b.b.a.bM(3, this.Udh);
      paramInt = i;
      if (this.SYn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SYn);
      }
      i = paramInt;
      if (this.TwK != null) {
        i = paramInt + g.a.a.a.oD(5, this.TwK.computeSize());
      }
      i += g.a.a.b.b.a.bM(6, this.CPw);
      paramInt = i;
      if (this.Sas != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Sas);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.Udl) + g.a.a.b.b.a.bM(9, this.UJW) + g.a.a.a.c(10, 8, this.UIj);
      paramInt = i;
      if (this.UJX != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.UJX);
      }
      i = paramInt;
      if (this.TQa != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TQa);
      }
      i += g.a.a.b.b.a.bM(13, this.Ute);
      paramInt = i;
      if (this.UJY != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.UJY);
      }
      i = paramInt;
      if (this.Uab != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.Uab);
      }
      i = i + g.a.a.a.c(16, 1, this.UJZ) + g.a.a.b.b.a.bM(17, this.UdE) + g.a.a.b.b.a.bM(18, this.rWu) + g.a.a.b.b.a.bM(19, this.UKa);
      paramInt = i;
      if (this.UKb != null) {
        paramInt = i + g.a.a.a.oD(20, this.UKb.computeSize());
      }
      AppMethodBeat.o(117948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UIj.clear();
      this.UJZ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      fle localfle = (fle)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117948);
        return -1;
      case 1: 
        localfle.Sat = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117948);
        return 0;
      case 2: 
        localfle.Tkv = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117948);
        return 0;
      case 3: 
        localfle.Udh = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117948);
        return 0;
      case 4: 
        localfle.SYn = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cqh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cqh)localObject2).parseFrom((byte[])localObject1);
          }
          localfle.TwK = ((cqh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 6: 
        localfle.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117948);
        return 0;
      case 7: 
        localfle.Sas = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 8: 
        localfle.Udl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117948);
        return 0;
      case 9: 
        localfle.UJW = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117948);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aci();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aci)localObject2).parseFrom((byte[])localObject1);
          }
          localfle.UIj.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 11: 
        localfle.UJX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 12: 
        localfle.TQa = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 13: 
        localfle.Ute = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117948);
        return 0;
      case 14: 
        localfle.UJY = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 15: 
        localfle.Uab = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 16: 
        localfle.UJZ.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(117948);
        return 0;
      case 17: 
        localfle.UdE = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117948);
        return 0;
      case 18: 
        localfle.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117948);
        return 0;
      case 19: 
        localfle.UKa = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117948);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bls();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bls)localObject2).parseFrom((byte[])localObject1);
        }
        localfle.UKb = ((bls)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    AppMethodBeat.o(117948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fle
 * JD-Core Version:    0.7.0.1
 */