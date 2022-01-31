package com.tencent.ttpic.ar.sensor.representation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MatrixF4x4
{
  public static final int[] matIndCol16_3x3;
  public static final int[] matIndCol16_4x4 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
  public static final int[] matIndCol9_3x3 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
  public static final int[] matIndRow16_3x3;
  public static final int[] matIndRow16_4x4 = { 0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15 };
  public static final int[] matIndRow9_3x3;
  private boolean colMaj;
  public float[] matrix;
  
  static
  {
    matIndCol16_3x3 = new int[] { 0, 1, 2, 4, 5, 6, 8, 9, 10 };
    matIndRow9_3x3 = new int[] { 0, 3, 6, 1, 4, 7, 3, 5, 8 };
    matIndRow16_3x3 = new int[] { 0, 4, 8, 1, 5, 9, 2, 6, 10 };
  }
  
  public MatrixF4x4()
  {
    AppMethodBeat.i(81692);
    this.colMaj = true;
    this.matrix = new float[16];
    Matrix.setIdentityM(this.matrix, 0);
    AppMethodBeat.o(81692);
  }
  
  public float[] getMatrix()
  {
    return this.matrix;
  }
  
  public boolean isColumnMajor()
  {
    return this.colMaj;
  }
  
  public void multiplyMatrix(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2)
  {
    int i = 0;
    while (i < 4)
    {
      int j = 0;
      while (j < 4)
      {
        int k = i * 4;
        int m = paramInt2 + 0 + j;
        paramArrayOfFloat2[m] += this.matrix[(k + j)] * paramArrayOfFloat1[(paramInt1 + 0 + i)];
        m = paramInt2 + 4 + j;
        paramArrayOfFloat2[m] += this.matrix[(k + j)] * paramArrayOfFloat1[(paramInt1 + 4 + i)];
        m = paramInt2 + 8 + j;
        paramArrayOfFloat2[m] += this.matrix[(k + j)] * paramArrayOfFloat1[(paramInt1 + 8 + i)];
        m = paramInt2 + 12 + j;
        float f = paramArrayOfFloat2[m];
        paramArrayOfFloat2[m] = (this.matrix[(k + j)] * paramArrayOfFloat1[(paramInt1 + 12 + i)] + f);
        j += 1;
      }
      i += 1;
    }
  }
  
  public void multiplyMatrix4x4ByMatrix(MatrixF4x4 paramMatrixF4x4)
  {
    AppMethodBeat.i(81697);
    float[] arrayOfFloat = new float[16];
    float[] tmp11_10 = arrayOfFloat;
    tmp11_10[0] = 0.0F;
    float[] tmp15_11 = tmp11_10;
    tmp15_11[1] = 0.0F;
    float[] tmp19_15 = tmp15_11;
    tmp19_15[2] = 0.0F;
    float[] tmp23_19 = tmp19_15;
    tmp23_19[3] = 0.0F;
    float[] tmp27_23 = tmp23_19;
    tmp27_23[4] = 0.0F;
    float[] tmp31_27 = tmp27_23;
    tmp31_27[5] = 0.0F;
    float[] tmp35_31 = tmp31_27;
    tmp35_31[6] = 0.0F;
    float[] tmp40_35 = tmp35_31;
    tmp40_35[7] = 0.0F;
    float[] tmp45_40 = tmp40_35;
    tmp45_40[8] = 0.0F;
    float[] tmp50_45 = tmp45_40;
    tmp50_45[9] = 0.0F;
    float[] tmp55_50 = tmp50_45;
    tmp55_50[10] = 0.0F;
    float[] tmp60_55 = tmp55_50;
    tmp60_55[11] = 0.0F;
    float[] tmp65_60 = tmp60_55;
    tmp65_60[12] = 0.0F;
    float[] tmp70_65 = tmp65_60;
    tmp70_65[13] = 0.0F;
    float[] tmp75_70 = tmp70_65;
    tmp75_70[14] = 0.0F;
    float[] tmp80_75 = tmp75_70;
    tmp80_75[15] = 0.0F;
    tmp80_75;
    multiplyMatrix(paramMatrixF4x4.getMatrix(), 0, arrayOfFloat, 0);
    paramMatrixF4x4.setMatrix(arrayOfFloat);
    AppMethodBeat.o(81697);
  }
  
  public void multiplyVector3fByMatrix(Vector3f paramVector3f)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(81696);
    if (this.matrix.length == 9)
    {
      float[] arrayOfFloat = paramVector3f.toArray();
      float f4;
      float f5;
      float f6;
      if (!this.colMaj)
      {
        f1 = 0.0F;
        f2 = 0.0F;
        f3 = 0.0F;
        for (;;)
        {
          f4 = f1;
          f5 = f2;
          f6 = f3;
          if (i >= 3) {
            break;
          }
          j = i * 3;
          f3 += this.matrix[(j + 0)] * arrayOfFloat[i];
          f2 += this.matrix[(j + 1)] * arrayOfFloat[i];
          f1 += this.matrix[(j + 2)] * arrayOfFloat[i];
          i += 1;
        }
      }
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      i = j;
      for (;;)
      {
        f4 = f1;
        f5 = f2;
        f6 = f3;
        if (i >= 3) {
          break;
        }
        f3 += this.matrix[(i + 0)] * arrayOfFloat[i];
        f2 += this.matrix[(i + 3)] * arrayOfFloat[i];
        f1 += this.matrix[(i + 6)] * arrayOfFloat[i];
        i += 1;
      }
      paramVector3f.setX(f6);
      paramVector3f.setY(f5);
      paramVector3f.setZ(f4);
      AppMethodBeat.o(81696);
      return;
    }
    new StringBuilder("Matrix is invalid, is ").append(this.matrix.length).append(" long, this function expects the internal matrix to be of size 9");
    AppMethodBeat.o(81696);
  }
  
  public void multiplyVector4fByMatrix(Vector4f paramVector4f)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(81695);
    if (this.matrix.length == 16)
    {
      float[] arrayOfFloat = paramVector4f.array();
      float f5;
      float f6;
      float f7;
      float f8;
      if (this.colMaj)
      {
        f1 = 0.0F;
        f2 = 0.0F;
        f3 = 0.0F;
        f4 = 0.0F;
        for (;;)
        {
          f5 = f1;
          f6 = f2;
          f7 = f3;
          f8 = f4;
          if (i >= 4) {
            break;
          }
          j = i * 4;
          f4 += this.matrix[(j + 0)] * arrayOfFloat[i];
          f3 += this.matrix[(j + 1)] * arrayOfFloat[i];
          f2 += this.matrix[(j + 2)] * arrayOfFloat[i];
          f1 += this.matrix[(j + 3)] * arrayOfFloat[i];
          i += 1;
        }
      }
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      float f4 = 0.0F;
      i = j;
      for (;;)
      {
        f5 = f1;
        f6 = f2;
        f7 = f3;
        f8 = f4;
        if (i >= 4) {
          break;
        }
        f4 += this.matrix[(i + 0)] * arrayOfFloat[i];
        f3 += this.matrix[(i + 4)] * arrayOfFloat[i];
        f2 += this.matrix[(i + 8)] * arrayOfFloat[i];
        f1 += this.matrix[(i + 12)] * arrayOfFloat[i];
        i += 1;
      }
      paramVector4f.setX(f8);
      paramVector4f.setY(f7);
      paramVector4f.setZ(f6);
      paramVector4f.setW(f5);
      AppMethodBeat.o(81695);
      return;
    }
    new StringBuilder("Matrix is invalid, is ").append(this.matrix.length).append(" long, this equation expects a 16 value matrix");
    AppMethodBeat.o(81695);
  }
  
  public void set(MatrixF4x4 paramMatrixF4x4)
  {
    AppMethodBeat.i(81694);
    System.arraycopy(paramMatrixF4x4.matrix, 0, this.matrix, 0, this.matrix.length);
    AppMethodBeat.o(81694);
  }
  
  public void setColumnMajor(boolean paramBoolean)
  {
    this.colMaj = paramBoolean;
  }
  
  public void setMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(81693);
    if ((paramArrayOfFloat.length == 16) || (paramArrayOfFloat.length == 9))
    {
      this.matrix = paramArrayOfFloat;
      AppMethodBeat.o(81693);
      return;
    }
    paramArrayOfFloat = new IllegalArgumentException("Matrix set is invalid, size is " + paramArrayOfFloat.length + " expected 9 or 16");
    AppMethodBeat.o(81693);
    throw paramArrayOfFloat;
  }
  
  public void setW0(float paramFloat)
  {
    AppMethodBeat.i(81701);
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[12]] = paramFloat;
        AppMethodBeat.o(81701);
        return;
      }
      this.matrix[matIndRow16_4x4[12]] = paramFloat;
      AppMethodBeat.o(81701);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("length of matrix should be 16");
    AppMethodBeat.o(81701);
    throw localIllegalStateException;
  }
  
  public void setW1(float paramFloat)
  {
    AppMethodBeat.i(81702);
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[13]] = paramFloat;
        AppMethodBeat.o(81702);
        return;
      }
      this.matrix[matIndRow16_4x4[13]] = paramFloat;
      AppMethodBeat.o(81702);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("length of matrix should be 16");
    AppMethodBeat.o(81702);
    throw localIllegalStateException;
  }
  
  public void setW2(float paramFloat)
  {
    AppMethodBeat.i(81703);
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[14]] = paramFloat;
        AppMethodBeat.o(81703);
        return;
      }
      this.matrix[matIndRow16_4x4[14]] = paramFloat;
      AppMethodBeat.o(81703);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("length of matrix should be 16");
    AppMethodBeat.o(81703);
    throw localIllegalStateException;
  }
  
  public void setW3(float paramFloat)
  {
    AppMethodBeat.i(81704);
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[15]] = paramFloat;
        AppMethodBeat.o(81704);
        return;
      }
      this.matrix[matIndRow16_4x4[15]] = paramFloat;
      AppMethodBeat.o(81704);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("length of matrix should be 16");
    AppMethodBeat.o(81704);
    throw localIllegalStateException;
  }
  
  public void setX0(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[0]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[0]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[0]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[0]] = paramFloat;
  }
  
  public void setX1(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[1]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[1]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[1]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[1]] = paramFloat;
  }
  
  public void setX2(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[2]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[2]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[2]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[2]] = paramFloat;
  }
  
  public void setX3(float paramFloat)
  {
    AppMethodBeat.i(81698);
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[3]] = paramFloat;
        AppMethodBeat.o(81698);
        return;
      }
      this.matrix[matIndRow16_4x4[3]] = paramFloat;
      AppMethodBeat.o(81698);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("length of matrix should be 16");
    AppMethodBeat.o(81698);
    throw localIllegalStateException;
  }
  
  public void setY0(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[3]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[3]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[3]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[3]] = paramFloat;
  }
  
  public void setY1(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[4]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[4]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[4]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[4]] = paramFloat;
  }
  
  public void setY2(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[5]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[5]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[5]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[5]] = paramFloat;
  }
  
  public void setY3(float paramFloat)
  {
    AppMethodBeat.i(81699);
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[7]] = paramFloat;
        AppMethodBeat.o(81699);
        return;
      }
      this.matrix[matIndRow16_4x4[7]] = paramFloat;
      AppMethodBeat.o(81699);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("length of matrix should be 16");
    AppMethodBeat.o(81699);
    throw localIllegalStateException;
  }
  
  public void setZ0(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[6]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[6]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[6]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[6]] = paramFloat;
  }
  
  public void setZ1(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[7]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[7]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[7]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[7]] = paramFloat;
  }
  
  public void setZ2(float paramFloat)
  {
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_3x3[8]] = paramFloat;
        return;
      }
      this.matrix[matIndRow16_3x3[8]] = paramFloat;
      return;
    }
    if (this.colMaj)
    {
      this.matrix[matIndCol9_3x3[8]] = paramFloat;
      return;
    }
    this.matrix[matIndRow9_3x3[8]] = paramFloat;
  }
  
  public void setZ3(float paramFloat)
  {
    AppMethodBeat.i(81700);
    if (this.matrix.length == 16)
    {
      if (this.colMaj)
      {
        this.matrix[matIndCol16_4x4[11]] = paramFloat;
        AppMethodBeat.o(81700);
        return;
      }
      this.matrix[matIndRow16_4x4[11]] = paramFloat;
      AppMethodBeat.o(81700);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("length of matrix should be 16");
    AppMethodBeat.o(81700);
    throw localIllegalStateException;
  }
  
  public int size()
  {
    return this.matrix.length;
  }
  
  public void transpose()
  {
    int j = 0;
    int i = 0;
    if (this.matrix.length == 16)
    {
      arrayOfFloat = new float[16];
      while (i < 4)
      {
        j = i * 4;
        arrayOfFloat[j] = this.matrix[i];
        arrayOfFloat[(j + 1)] = this.matrix[(i + 4)];
        arrayOfFloat[(j + 2)] = this.matrix[(i + 8)];
        arrayOfFloat[(j + 3)] = this.matrix[(i + 12)];
        i += 1;
      }
      this.matrix = arrayOfFloat;
      return;
    }
    float[] arrayOfFloat = new float[9];
    i = j;
    while (i < 3)
    {
      j = i * 3;
      arrayOfFloat[j] = this.matrix[i];
      arrayOfFloat[(j + 1)] = this.matrix[(i + 3)];
      arrayOfFloat[(j + 2)] = this.matrix[(i + 6)];
      i += 1;
    }
    this.matrix = arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.representation.MatrixF4x4
 * JD-Core Version:    0.7.0.1
 */