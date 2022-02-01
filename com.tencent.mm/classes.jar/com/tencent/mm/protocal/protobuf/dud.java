package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class dud
  extends com.tencent.mm.cd.a
{
  public int Uan;
  public String Uao;
  public String Uap;
  public String Uaq;
  public double Uar;
  public String Uas;
  public cho Uat;
  public String Uau;
  public String Uav;
  public String jEx;
  public String qJp;
  public String qJq;
  public String qJr;
  public String qJs;
  public int qJt;
  public String qJu;
  public String ufJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50101);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.qJt);
      paramVarArgs.aY(2, this.Uan);
      if (this.jEx != null) {
        paramVarArgs.f(3, this.jEx);
      }
      if (this.qJr != null) {
        paramVarArgs.f(4, this.qJr);
      }
      if (this.qJs != null) {
        paramVarArgs.f(5, this.qJs);
      }
      if (this.Uao != null) {
        paramVarArgs.f(6, this.Uao);
      }
      if (this.ufJ != null) {
        paramVarArgs.f(7, this.ufJ);
      }
      if (this.Uap != null) {
        paramVarArgs.f(8, this.Uap);
      }
      if (this.Uaq != null) {
        paramVarArgs.f(9, this.Uaq);
      }
      paramVarArgs.e(10, this.Uar);
      if (this.Uas != null) {
        paramVarArgs.f(11, this.Uas);
      }
      if (this.qJp != null) {
        paramVarArgs.f(12, this.qJp);
      }
      if (this.Uat != null)
      {
        paramVarArgs.oE(14, this.Uat.computeSize());
        this.Uat.writeFields(paramVarArgs);
      }
      if (this.qJq != null) {
        paramVarArgs.f(15, this.qJq);
      }
      if (this.Uau != null) {
        paramVarArgs.f(16, this.Uau);
      }
      if (this.Uav != null) {
        paramVarArgs.f(17, this.Uav);
      }
      if (this.qJu != null) {
        paramVarArgs.f(18, this.qJu);
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.qJt) + 0 + g.a.a.b.b.a.bM(2, this.Uan);
      paramInt = i;
      if (this.jEx != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.jEx);
      }
      i = paramInt;
      if (this.qJr != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.qJr);
      }
      paramInt = i;
      if (this.qJs != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.qJs);
      }
      i = paramInt;
      if (this.Uao != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Uao);
      }
      paramInt = i;
      if (this.ufJ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ufJ);
      }
      i = paramInt;
      if (this.Uap != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Uap);
      }
      paramInt = i;
      if (this.Uaq != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Uaq);
      }
      i = paramInt + (g.a.a.b.b.a.gL(10) + 8);
      paramInt = i;
      if (this.Uas != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Uas);
      }
      i = paramInt;
      if (this.qJp != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.qJp);
      }
      paramInt = i;
      if (this.Uat != null) {
        paramInt = i + g.a.a.a.oD(14, this.Uat.computeSize());
      }
      i = paramInt;
      if (this.qJq != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.qJq);
      }
      paramInt = i;
      if (this.Uau != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.Uau);
      }
      i = paramInt;
      if (this.Uav != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.Uav);
      }
      paramInt = i;
      if (this.qJu != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.qJu);
      }
      AppMethodBeat.o(50101);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dud localdud = (dud)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(50101);
        return -1;
      case 1: 
        localdud.qJt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(50101);
        return 0;
      case 2: 
        localdud.Uan = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(50101);
        return 0;
      case 3: 
        localdud.jEx = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 4: 
        localdud.qJr = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 5: 
        localdud.qJs = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 6: 
        localdud.Uao = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 7: 
        localdud.ufJ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 8: 
        localdud.Uap = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 9: 
        localdud.Uaq = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 10: 
        localdud.Uar = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
        AppMethodBeat.o(50101);
        return 0;
      case 11: 
        localdud.Uas = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 12: 
        localdud.qJp = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 14: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cho localcho = new cho();
          if ((localObject != null) && (localObject.length > 0)) {
            localcho.parseFrom((byte[])localObject);
          }
          localdud.Uat = localcho;
          paramInt += 1;
        }
        AppMethodBeat.o(50101);
        return 0;
      case 15: 
        localdud.qJq = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 16: 
        localdud.Uau = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 17: 
        localdud.Uav = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(50101);
        return 0;
      }
      localdud.qJu = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(50101);
      return 0;
    }
    AppMethodBeat.o(50101);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dud
 * JD-Core Version:    0.7.0.1
 */