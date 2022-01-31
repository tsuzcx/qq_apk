package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class pendantConfig
  extends JceStruct
{
  static pendantStageConfig cache_medium_stage = new pendantStageConfig();
  static pendantStageConfig cache_strong_stage = new pendantStageConfig();
  static pendantStageConfig cache_weak_stage = new pendantStageConfig();
  public int cid;
  public boolean enable;
  public pendantStageConfig medium_stage;
  public pendantStageConfig strong_stage;
  public pendantStageConfig weak_stage;
  
  public pendantConfig() {}
  
  public pendantConfig(boolean paramBoolean, pendantStageConfig parampendantStageConfig1, pendantStageConfig parampendantStageConfig2, pendantStageConfig parampendantStageConfig3, int paramInt)
  {
    this.enable = paramBoolean;
    this.weak_stage = parampendantStageConfig1;
    this.medium_stage = parampendantStageConfig2;
    this.strong_stage = parampendantStageConfig3;
    this.cid = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.enable = paramJceInputStream.read(this.enable, 0, false);
    this.weak_stage = ((pendantStageConfig)paramJceInputStream.read(cache_weak_stage, 1, false));
    this.medium_stage = ((pendantStageConfig)paramJceInputStream.read(cache_medium_stage, 2, false));
    this.strong_stage = ((pendantStageConfig)paramJceInputStream.read(cache_strong_stage, 3, false));
    this.cid = paramJceInputStream.read(this.cid, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.enable, 0);
    if (this.weak_stage != null) {
      paramJceOutputStream.write(this.weak_stage, 1);
    }
    if (this.medium_stage != null) {
      paramJceOutputStream.write(this.medium_stage, 2);
    }
    if (this.strong_stage != null) {
      paramJceOutputStream.write(this.strong_stage, 3);
    }
    paramJceOutputStream.write(this.cid, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.pendantConfig
 * JD-Core Version:    0.7.0.1
 */