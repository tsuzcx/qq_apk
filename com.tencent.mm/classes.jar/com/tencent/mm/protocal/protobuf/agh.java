package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class agh
  extends com.tencent.mm.bx.a
{
  public bmr DHa;
  public String IGG;
  public String Url;
  public bvm ZpA;
  public int Zpq;
  public LinkedList<dmz> Zpr;
  public int Zps;
  public String Zpt;
  public dll Zpu;
  public bvn Zpv;
  public jz Zpw;
  public bvh Zpx;
  public doc Zpy;
  public bvn Zpz;
  public gom akiL;
  public String hAP;
  public bvl hKU;
  public int nUa;
  public dtj oPb;
  
  public agh()
  {
    AppMethodBeat.i(125718);
    this.Zpr = new LinkedList();
    AppMethodBeat.o(125718);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125719);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGG != null) {
        paramVarArgs.g(1, this.IGG);
      }
      paramVarArgs.bS(2, this.Zpq);
      if (this.hAP != null) {
        paramVarArgs.g(3, this.hAP);
      }
      if (this.Url != null) {
        paramVarArgs.g(4, this.Url);
      }
      paramVarArgs.e(5, 8, this.Zpr);
      paramVarArgs.bS(6, this.Zps);
      if (this.Zpt != null) {
        paramVarArgs.g(7, this.Zpt);
      }
      if (this.Zpu != null)
      {
        paramVarArgs.qD(8, this.Zpu.computeSize());
        this.Zpu.writeFields(paramVarArgs);
      }
      if (this.hKU != null)
      {
        paramVarArgs.qD(9, this.hKU.computeSize());
        this.hKU.writeFields(paramVarArgs);
      }
      if (this.Zpv != null)
      {
        paramVarArgs.qD(10, this.Zpv.computeSize());
        this.Zpv.writeFields(paramVarArgs);
      }
      if (this.Zpw != null)
      {
        paramVarArgs.qD(11, this.Zpw.computeSize());
        this.Zpw.writeFields(paramVarArgs);
      }
      if (this.Zpx != null)
      {
        paramVarArgs.qD(12, this.Zpx.computeSize());
        this.Zpx.writeFields(paramVarArgs);
      }
      if (this.DHa != null)
      {
        paramVarArgs.qD(13, this.DHa.computeSize());
        this.DHa.writeFields(paramVarArgs);
      }
      if (this.Zpy != null)
      {
        paramVarArgs.qD(14, this.Zpy.computeSize());
        this.Zpy.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(15, this.nUa);
      if (this.Zpz != null)
      {
        paramVarArgs.qD(16, this.Zpz.computeSize());
        this.Zpz.writeFields(paramVarArgs);
      }
      if (this.oPb != null)
      {
        paramVarArgs.qD(17, this.oPb.computeSize());
        this.oPb.writeFields(paramVarArgs);
      }
      if (this.ZpA != null)
      {
        paramVarArgs.qD(18, this.ZpA.computeSize());
        this.ZpA.writeFields(paramVarArgs);
      }
      if (this.akiL != null)
      {
        paramVarArgs.qD(19, this.akiL.computeSize());
        this.akiL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGG == null) {
        break label2122;
      }
    }
    label2122:
    for (paramInt = i.a.a.b.b.a.h(1, this.IGG) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zpq);
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hAP);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Url);
      }
      i = i + i.a.a.a.c(5, 8, this.Zpr) + i.a.a.b.b.a.cJ(6, this.Zps);
      paramInt = i;
      if (this.Zpt != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zpt);
      }
      i = paramInt;
      if (this.Zpu != null) {
        i = paramInt + i.a.a.a.qC(8, this.Zpu.computeSize());
      }
      paramInt = i;
      if (this.hKU != null) {
        paramInt = i + i.a.a.a.qC(9, this.hKU.computeSize());
      }
      i = paramInt;
      if (this.Zpv != null) {
        i = paramInt + i.a.a.a.qC(10, this.Zpv.computeSize());
      }
      paramInt = i;
      if (this.Zpw != null) {
        paramInt = i + i.a.a.a.qC(11, this.Zpw.computeSize());
      }
      i = paramInt;
      if (this.Zpx != null) {
        i = paramInt + i.a.a.a.qC(12, this.Zpx.computeSize());
      }
      paramInt = i;
      if (this.DHa != null) {
        paramInt = i + i.a.a.a.qC(13, this.DHa.computeSize());
      }
      i = paramInt;
      if (this.Zpy != null) {
        i = paramInt + i.a.a.a.qC(14, this.Zpy.computeSize());
      }
      i += i.a.a.b.b.a.cJ(15, this.nUa);
      paramInt = i;
      if (this.Zpz != null) {
        paramInt = i + i.a.a.a.qC(16, this.Zpz.computeSize());
      }
      i = paramInt;
      if (this.oPb != null) {
        i = paramInt + i.a.a.a.qC(17, this.oPb.computeSize());
      }
      paramInt = i;
      if (this.ZpA != null) {
        paramInt = i + i.a.a.a.qC(18, this.ZpA.computeSize());
      }
      i = paramInt;
      if (this.akiL != null) {
        i = paramInt + i.a.a.a.qC(19, this.akiL.computeSize());
      }
      AppMethodBeat.o(125719);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zpr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        agh localagh = (agh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125719);
          return -1;
        case 1: 
          localagh.IGG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 2: 
          localagh.Zpq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125719);
          return 0;
        case 3: 
          localagh.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 4: 
          localagh.Url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmz)localObject2).parseFrom((byte[])localObject1);
            }
            localagh.Zpr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 6: 
          localagh.Zps = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125719);
          return 0;
        case 7: 
          localagh.Zpt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dll();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dll)localObject2).parseFrom((byte[])localObject1);
            }
            localagh.Zpu = ((dll)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvl)localObject2).parseFrom((byte[])localObject1);
            }
            localagh.hKU = ((bvl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvn)localObject2).parseFrom((byte[])localObject1);
            }
            localagh.Zpv = ((bvn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jz)localObject2).parseFrom((byte[])localObject1);
            }
            localagh.Zpw = ((jz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvh)localObject2).parseFrom((byte[])localObject1);
            }
            localagh.Zpx = ((bvh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmr)localObject2).parseFrom((byte[])localObject1);
            }
            localagh.DHa = ((bmr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new doc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((doc)localObject2).parseFrom((byte[])localObject1);
            }
            localagh.Zpy = ((doc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 15: 
          localagh.nUa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125719);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvn)localObject2).parseFrom((byte[])localObject1);
            }
            localagh.Zpz = ((bvn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtj)localObject2).parseFrom((byte[])localObject1);
            }
            localagh.oPb = ((dtj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvm)localObject2).parseFrom((byte[])localObject1);
            }
            localagh.ZpA = ((bvm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gom();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gom)localObject2).parseFrom((byte[])localObject1);
          }
          localagh.akiL = ((gom)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      AppMethodBeat.o(125719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agh
 * JD-Core Version:    0.7.0.1
 */